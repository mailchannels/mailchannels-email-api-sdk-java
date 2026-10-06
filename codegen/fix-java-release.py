"""Replace generator placeholder metadata and reconcile corrected API documentation."""
import re
import shutil
import sys
from pathlib import Path
sdk=Path(sys.argv[1]); source=Path(__file__).parent/'java-release'
p=sdk/'pom.xml';text=p.read_text()
assert '<name>mailchannels-email-api</name>' in text
text=text.replace('<name>mailchannels-email-api</name>','<name>MailChannels Email API SDK</name>',1)
text=text.replace('<description>OpenAPI Java</description>','<description>MailChannels Email API client for Java and Kotlin</description>',1)
text=text.replace('<url>https://github.com/openapitools/openapi-generator</url>','<url>https://www.mailchannels.com/</url>',1)
text,n=re.subn(r'    <scm>.*?</scm>', '''    <scm>
        <connection>scm:git:https://github.com/mailchannels/mailchannels-email-api-sdk-java.git</connection>
        <developerConnection>scm:git:https://github.com/mailchannels/mailchannels-email-api-sdk-java.git</developerConnection>
        <url>https://github.com/mailchannels/mailchannels-email-api-sdk-java</url>
    </scm>''',text,count=1,flags=re.S);assert n==1
text,n=re.subn(r'    <licenses>.*?</licenses>', '''    <licenses><license><name>MIT License</name><url>https://opensource.org/license/mit/</url><distribution>repo</distribution></license></licenses>''',text,count=1,flags=re.S);assert n==1
text,n=re.subn(r'    <developers>.*?</developers>', '''    <developers><developer><name>MailChannels</name><email>dev@mailchannels.com</email><organization>MailChannels</organization><organizationUrl>https://www.mailchannels.com/</organizationUrl></developer></developers>''',text,count=1,flags=re.S);assert n==1
p.write_text(text)
shutil.copy2(source/'LICENSE',sdk/'LICENSE')
shutil.copy2(source/'README.md',sdk/'README.md')
license_dir=sdk/'src/main/resources/META-INF';license_dir.mkdir(parents=True,exist_ok=True)
shutil.copy2(source/'LICENSE',license_dir/'LICENSE')
for p in (sdk/'docs').glob('*Api.md'):
    text=p.read_text().replace('com.mailchannels.client.models.*','com.mailchannels.model.*')
    text=text.replace('import com.mailchannels.client.ApiClient;', 'import com.mailchannels.client.ApiClient;\nimport com.mailchannels.client.ApiResponse;')
    text=text.replace('        defaultClient.setBasePath("https://api.mailchannels.net/tx/v1");','        // ApiClient already uses the MailChannels HTTPS endpoint.')
    text='\n'.join(line for line in text.split('\n') if 'System.err.println("Reason: " + e.getResponseBody())' not in line and 'System.err.println("Response headers: " + e.getResponseHeaders())' not in line)
    corrections={'sendEmail':('Message','SendEmailResult'),'createCustomTrackingDomain':('CustomTrackingDomain','CreateTrackingResult'),'updateCustomTrackingDomain':('CustomTrackingDomain','UpdateTrackingResult')}
    sections=re.split(r'(?=^## )',text,flags=re.M)
    for index,section in enumerate(sections):
        for method,(old,new) in corrections.items():
            if section.startswith('## '+method+'\n') or section.startswith('## '+method+'WithHttpInfo\n'):
                sections[index]=re.sub(r'\b'+old+r'\b',new,section)
    text=''.join(sections)
    def fix_imports(match):
        code=match.group(1)
        imports=[]; body=[]
        for line in code.splitlines():
            if line.startswith('import '):
                if line not in imports: imports.append(line)
            elif 'System.out.println("Response headers: " + response.getHeaders())' not in line:
                body.append(line)
        if 'List<' in code and 'import java.util.List;' not in imports:
            imports.append('import java.util.List;')
        if 'Arrays.' in code and 'import java.util.Arrays;' not in imports:
            imports.append('import java.util.Arrays;')
        return '```java\n'+'\n'.join(imports+body)+'\n```'
    text=re.sub(r'```java\n(.*?)```',fix_imports,text,flags=re.S)
    p.write_text(text)
for model,variants in [('SendEmailResult','getDryRun(): HTTP 200 Message; getAccepted(): HTTP 202 SendResults'),('CreateTrackingResult','getCreated(): HTTP 201 CustomTrackingDomain; getAccepted(): HTTP 202 DnsSetupRequired'),('UpdateTrackingResult','getUpdated(): HTTP 200 CustomTrackingDomain; getAccepted(): HTTP 202 DnsSetupRequired')]:
    (sdk/'docs'/f'{model}.md').write_text(f'# {model}\n\nStatus-specific response wrapper. {variants}.\n\nNonmatching typed getters return null. getStatusCode() retains the HTTP status.\ngetUnknown() retains JSON for undocumented success statuses. Empty responses can\nhave null data. Routine toString() is redacted; explicit getters expose data.\n')
print('Applied MailChannels package metadata, MIT license and corrected API docs')
