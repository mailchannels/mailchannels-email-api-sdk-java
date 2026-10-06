"""Inspect main/source/Javadoc candidate artifacts; does not sign or publish."""
import hashlib
import json
import sys
import zipfile
from pathlib import Path
sdk=Path(sys.argv[1]); output=Path(sys.argv[2])
base='mailchannels-email-api-0.1.0-SNAPSHOT'
paths={'main':sdk/'target'/f'{base}.jar','sources':sdk/'target'/f'{base}-sources.jar','javadoc':sdk/'target'/f'{base}-javadoc.jar'}
java=sdk/'src/main/java'
sources=sorted(java.rglob('*.java'))
assert len(sources)>80, 'Unexpected source inventory'
with zipfile.ZipFile(paths['main']) as binary, zipfile.ZipFile(paths['sources']) as source, zipfile.ZipFile(paths['javadoc']) as docs:
    for p in sources:
        relative=p.relative_to(java).as_posix()
        assert source.read(relative)==p.read_bytes(),f'Source archive differs: {relative}'
        assert relative[:-5]+'.class' in binary.namelist(),f'Missing bytecode: {relative}'
        assert relative[:-5]+'.html' in docs.namelist(),f'Missing Javadoc: {relative}'
    license=(sdk/'LICENSE').read_bytes()
    assert binary.read('META-INF/LICENSE')==license
    assert source.read('META-INF/LICENSE')==license
    pom=binary.read('META-INF/maven/com.mailchannels/mailchannels-email-api/pom.xml')
    assert pom==(sdk/'pom.xml').read_bytes(), 'Embedded POM mismatch'
    assert b'2.21.7' in pom and b'dev@mailchannels.com' in pom
    for name in ['SendEmailResult','CreateTrackingResult','UpdateTrackingResult']:
        page=docs.read(f'com/mailchannels/model/{name}.html')
        assert b'getStatusCode' in page and b'getUnknown' in page
    assert b'SendEmailResult' in docs.read('com/mailchannels/api/SendApi.html')
    for label,z in [('main',binary),('sources',source)]:
        assert not any(n.startswith(('target/','src/test/','.git/')) for n in z.namelist()),f'Unexpected build/test metadata in {label}'
report={'status':'Unreleased local snapshot; unsigned and not published','java_sources_verified':len(sources),'checks':['Every maintained Java source byte-matches source JAR','Every source has main bytecode and Javadoc page','Status-aware wrapper docs present','MIT license embedded in main/source JAR','Embedded POM matches reviewed metadata and Jackson patch'],'artifacts':[]}
for kind,p in paths.items():
    report['artifacts'].append({'kind':kind,'filename':p.name,'bytes':p.stat().st_size,'sha256':hashlib.sha256(p.read_bytes()).hexdigest()})
output.write_text(json.dumps(report,indent=2)+'\n')
print(f'Inspected {len(sources)} Java sources and all three candidate artifacts; no signing or publication')
