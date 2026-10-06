"""Redact default diagnostics after pinned Java generation; retain explicit data."""
import re
import sys
from pathlib import Path
sdk=Path(sys.argv[1])/'src/main/java/com/mailchannels'
count=0
for path in (sdk/'model').glob('*.java'):
    text=path.read_text()
    pattern=r'(public String toString\(\) \{)\s*StringBuilder sb = new StringBuilder\(\);.*?return sb.toString\(\);\s*\}'
    text,n=re.subn(pattern,lambda m:m[1]+'\n    return "'+path.stem+' { [REDACTED] }";\n  }',text,flags=re.S)
    assert n<=1, f'{path}: unexpected model shape'
    if n: path.write_text(text); count+=1
assert count>0, 'No generated model diagnostics matched; review generator update'
p=sdk/'client/ApiException.java'; text=p.read_text()
assert 'public ApiException(Throwable throwable)' in text and 'getRawCause' not in text, 'Exception layout changed'
pos=text.rfind('}')
text=text[:pos]+'''    /** Safe routine message; raw details require explicit access. */
    @Override public String getMessage() {
        return "MailChannels API request failed (status " + code + "); details redacted";
    }

    /** Suppress raw nested exception details in standard stack traces. */
    @Override public synchronized Throwable getCause() { return null; }

    /** Explicit unredacted message. Do not log without reviewing its content. */
    public String getRawMessage() { return super.getMessage(); }

    /** Explicit unredacted cause, excluded from ordinary stack traces. */
    public synchronized Throwable getRawCause() { return super.getCause(); }
''' +text[pos:]
p.write_text(text)
print(f'Redacted {count} generated model ToString methods and ApiException diagnostics')
