#!/usr/bin/env bash
source "$(dirname "$0")/common.sh"
generator=openapitools/openapi-generator-cli:v7.26.0@sha256:a304ddf1e2e5f24f68fa3153568d6174cea4959d09aa8e3db6d526fd0782326d
run_uid="$(id -u):$(id -g)"
if docker info --format '{{json .SecurityOptions}}' | grep -q rootless; then run_uid=0:0; fi
python "$root/codegen/prepare-spec.py" "$root/.build/openapi.json"
docker run --rm --network none --user "$run_uid" -v "$root/codegen:/codegen:ro" -v "$root/.build:/output" "$generator" generate -i /output/openapi.json -g java -c /codegen/config/java.json -o /output/generated
for step in responses diagnostics transport optional-bodies dependencies release; do
 python "$root/codegen/fix-java-$step.py" "$root/.build/generated"
done
python - "$root" <<'PY'
import shutil,sys
from pathlib import Path
root=Path(sys.argv[1]); generated=root/'.build/generated'
for name in ['docs','src/main']:
 shutil.rmtree(root/name)
 shutil.copytree(generated/name,root/name)
for name in ['pom.xml','README.md','LICENSE']:shutil.copy2(generated/name,root/name)
PY
