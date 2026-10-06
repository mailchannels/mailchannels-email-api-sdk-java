#!/usr/bin/env bash
set -euo pipefail
root=$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)
image=${SDK_JAVA_IMAGE:-maven@sha256:99e61abcff91a9b1333463bd8451fb18495d6eba9250ac66a338b518f8278320}
mkdir -p "$root/.build"
args=(--rm -v "$root:/sdk" -v mailchannels-java-maven:/root/.m2 -w /sdk)
