"""Apply complete-body deadlines to all operations of the pinned native generator."""
import sys
from pathlib import Path
sdk = Path(sys.argv[1]) / 'src/main/java/com/mailchannels'
source = Path(__file__).parent
old = '''memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream())'''
count = 0
for path in (sdk / 'api').glob('*.java'):
    text = path.read_text()
    count += text.count(old)
    text = text.replace(old, '''com.mailchannels.client.BoundedHttpTransport.send(
          memberVarHttpClient, localVarRequestBuilder.build())''')
    path.write_text(text)
assert count == 42, f'Expected 42 generated sends, found {count}'
p = sdk / 'client/ApiClient.java'
text = p.read_text()
assert text.count('readTimeout = null;') == 2
text = text.replace('readTimeout = null;', 'readTimeout = Duration.ofSeconds(30);')
text = text.replace('connectTimeout = null;', 'connectTimeout = Duration.ofSeconds(10);', 1)
assert text.count('return HttpClient.newBuilder();') == 1
text = text.replace('return HttpClient.newBuilder();', '''return HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
        .followRedirects(HttpClient.Redirect.NEVER);''')
p.write_text(text)
(sdk / 'client/BoundedHttpTransport.java').write_text(
    (source / 'java-transport/BoundedHttpTransport.java').read_text())
print(f'Applied complete-response deadlines to {count} operations')
