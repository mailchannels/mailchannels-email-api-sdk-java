"""Query OSV for every resolved Maven dependency (including test scope).

Build plugins, JDK/OS packages and the separate Kotlin consumer are outside scope.
"""
import json
import sys
from datetime import datetime, timezone
from pathlib import Path
from urllib.request import Request, urlopen

tree=json.loads(Path(sys.argv[1]).read_text())
output=Path(sys.argv[2])
packages={}
def walk(node):
    for child in node.get('children',[]):
        key=(child['groupId']+':'+child['artifactId'],child['version'])
        packages.setdefault(key,set()).add(child['scope'])
        walk(child)
walk(tree)
assert packages, 'No resolved dependencies'
queries=[{'package':{'ecosystem':'Maven','name':name},'version':version} for name,version in sorted(packages)]
request=Request('https://api.osv.dev/v1/querybatch',data=json.dumps({'queries':queries}).encode(),headers={'Content-Type':'application/json'},method='POST')
with urlopen(request,timeout=60) as response:
    result=json.load(response)
assert 'error' not in result and not any('error' in r for r in result.get('results',[])), 'OSV returned an error'
assert len(result['results'])==len(queries), 'Incomplete OSV response'
# Fail closed if API pagination appears; never report a partial advisory result as clean.
assert not any(r.get('next_page_token') for r in result['results']), 'OSV pagination requires follow-up'
report={'checked_at':datetime.now(timezone.utc).isoformat(),'source':'https://api.osv.dev/v1/querybatch','scope':'Resolved SDK Maven dependencies including test scope; excludes build plugins, Kotlin consumer, JDK and OS','dependencies':[]}
for query,item in zip(queries,result['results']):
    name=query['package']['name'];version=query['version']
    report['dependencies'].append({'name':name,'version':version,'scopes':sorted(packages[(name,version)]),'advisories':item.get('vulns',[])})
report['advisory_ids']=sorted({v['id'] for d in report['dependencies'] for v in d['advisories']})
output.write_text(json.dumps(report,indent=2)+'\n')
print(f"Queried {len(queries)} resolved Maven packages; {len(report['advisory_ids'])} advisory IDs. Evidence: {output}")
if report['advisory_ids']: sys.exit(1)
