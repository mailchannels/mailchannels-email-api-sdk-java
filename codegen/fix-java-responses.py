"""Apply checked response-type corrections to pinned native Java generation."""
import re
import shutil
import sys
from pathlib import Path
base=Path(__file__).resolve().parent
sdk=Path(sys.argv[1])
corrections=[('SendApi','sendEmail','Message','SendEmailResult'),('CustomTrackingApi','createCustomTrackingDomain','CustomTrackingDomain','CreateTrackingResult'),('CustomTrackingApi','updateCustomTrackingDomain','CustomTrackingDomain','UpdateTrackingResult')]
for api,method,old,new in corrections:
    path=sdk/f'src/main/java/com/mailchannels/api/{api}.java'
    source=path.read_text()
    first=source.index(f'  public {old} {method}(')
    start=source.rfind('  /**',0,first)
    end=source.index(f'  private HttpRequest.Builder {method}RequestBuilder(',first)
    section=source[start:end]
    expected=f'{old} responseValue = responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<{old}>() {{}});'
    assert section.count(expected)==1, f'{method}: generator decoding changed; review correction'
    section=section.replace(expected,f'{new} responseValue = {new}.decode(localVarResponse.statusCode(), responseBody, memberVarObjectMapper);')
    section=re.sub(r'\b'+old+r'\b',new,section)
    source=source[:start]+section+source[end:]
    source=source.replace('import com.mailchannels.client.ApiClient;',f'import com.mailchannels.model.{new};\nimport com.mailchannels.client.ApiClient;',1)
    # JSON is UTF-8, independent of JVM locale/default charset.
    source=source.replace('new String(localVarResponseBody.readAllBytes())','new String(localVarResponseBody.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8)')
    path.write_text(source)
for path in (base/'java-custom').glob('*.java'):
    shutil.copy2(path,sdk/'src/main/java/com/mailchannels/model'/path.name)
print('Applied three checked Java status-aware response mappings')
