#!/usr/bin/env bash
source "$(dirname "$0")/common.sh"
docker run "${args[@]}" "$image" mvn -B org.apache.maven.plugins:maven-dependency-plugin:3.8.1:tree -DoutputType=json -DoutputFile=target/audit-dependencies.json
python "$root/scripts/audit-java.py" "$root/target/audit-dependencies.json" "$root/.build/advisory-audit.json"
