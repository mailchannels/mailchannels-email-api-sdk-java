#!/usr/bin/env bash
source "$(dirname "$0")/common.sh"
docker run "${args[@]}" "$image" mvn -B -Dmaven.test.skip=true clean package
python "$root/scripts/inspect-java-artifacts.py" "$root" "$root/.build/artifact-manifest.json"
