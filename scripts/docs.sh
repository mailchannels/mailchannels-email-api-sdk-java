#!/usr/bin/env bash
source "$(dirname "$0")/common.sh"
docker run "${args[@]}" "$image" mvn -B -Dmaven.test.skip=true package org.apache.maven.plugins:maven-dependency-plugin:3.8.1:build-classpath -Dmdep.outputFile=target/probe-classpath.txt
python "$root/scripts/check-java-examples.py" "$root" "$root/.build/doc-examples"
docker run "${args[@]}" --network none "$image" bash -c '
set -euo pipefail
mkdir -p target/doc-example-classes
javac --release 11 -cp "target/mailchannels-email-api-0.1.0-SNAPSHOT.jar:$(cat target/probe-classpath.txt)" -d target/doc-example-classes .build/doc-examples/*.java
'
echo '84 API examples compile; none executed'
