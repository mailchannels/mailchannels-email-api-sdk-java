"""Extract documentation snippets for compilation only. Never execute them."""
import re
import sys
from pathlib import Path
sdk=Path(sys.argv[1]);output=Path(sys.argv[2]);output.mkdir(parents=True,exist_ok=True)
count=0
for path in sorted((sdk/'docs').glob('*Api.md')):
    for index,code in enumerate(re.findall(r'```java\n(.*?)```',path.read_text(),re.S)):
        name=f'{path.stem}Example{index}'
        assert code.count('public class Example')==1, f'Unexpected snippet shape: {path}'
        (output/f'{name}.java').write_text(code.replace('public class Example',f'public class {name}'))
        count+=1
assert count==84,f'Expected two examples per operation, got {count}'
print(f'Extracted {count} documentation snippets; compile only, never execute')
