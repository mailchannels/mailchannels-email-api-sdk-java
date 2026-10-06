"""Omit absent optional request bodies instead of transmitting JSON null."""
import sys
from pathlib import Path
sdk=Path(sys.argv[1])/'src/main/java/com/mailchannels/api'
for filename,method,parameter in [('SubAccountsApi.java','createSubaccount','subAccountData'),('WebhooksApi.java','validateWebhook','webhookValidationRequestBody')]:
    path=sdk/filename
    text=path.read_text()
    start=text.index(f'  private HttpRequest.Builder {method}RequestBuilder(')
    end=text.index('    return localVarRequestBuilder;',start)
    section=text[start:end]
    header='    localVarRequestBuilder.header("Content-Type", "application/json");'
    assert section.count(header)==1
    section=section.replace(header,f'    if ({parameter} != null) localVarRequestBuilder.header("Content-Type", "application/json");')
    old=f'''      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes({parameter});
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));'''
    assert section.count(old)==1
    section=section.replace(old,f'''      if ({parameter} == null) {{
        localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
      }} else {{
        byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes({parameter});
        localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
      }}''')
    path.write_text(text[:start]+section+text[end:])
print('Corrected two optional Java request bodies')
