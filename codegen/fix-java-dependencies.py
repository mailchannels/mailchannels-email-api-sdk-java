"""Pin the reviewed Jackson patch release after native Java generation."""
import sys
from pathlib import Path
path=Path(sys.argv[1])/'pom.xml'
text=path.read_text()
old='<jackson-version>2.21.6</jackson-version>'
assert text.count(old)==1, 'Review Jackson baseline after generator changes'
path.write_text(text.replace(old,'<jackson-version>2.21.7</jackson-version>'))
print('Pinned Jackson core/databind/jsr310 to 2.21.7')
