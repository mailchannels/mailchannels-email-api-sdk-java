#!/usr/bin/env bash
source "$(dirname "$0")/common.sh"
docker run "${args[@]}" "$image" mvn -B -Dmaven.test.skip=true package org.apache.maven.plugins:maven-dependency-plugin:3.8.1:build-classpath -Dmdep.outputFile=target/probe-classpath.txt
tls_dir=$(mktemp -d)
trap 'rm -rf "$tls_dir"' EXIT
python "$root/tests/tls-certificates.py" "$tls_dir"
docker run "${args[@]}" --network none --add-host fixture.test:127.0.0.1 -v "$tls_dir:/tls:ro" "$image" bash -c '
set -euo pipefail
probe_cp="target/classes:$(cat target/probe-classpath.txt)"
mkdir -p target/probe-classes
javac -cp "$probe_cp" -d target/probe-classes tests/java/*.java
for probe in SendResponseProbe DiagnosticsProbe TransportProbe TlsProbe EndpointProbe ManagementProbe CancellationProbe; do
 java -cp "target/probe-classes:$probe_cp" "$probe" /tls
done
'
