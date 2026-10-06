#!/usr/bin/env bash
source "$(dirname "$0")/common.sh"
docker run "${args[@]}" "$image" mvn -B -Dmaven.test.skip=true install
consumer="$root/.build/kotlin"
mkdir -p "$consumer"
cp -R "$root/tests/kotlin/." "$consumer/"
consumer_args=(--rm -v "$consumer:/consumer" -v mailchannels-java-maven:/root/.m2 -w /consumer)
docker run "${consumer_args[@]}" "$image" mvn -B clean package org.apache.maven.plugins:maven-dependency-plugin:3.8.1:build-classpath -Dmdep.outputFile=target/runtime-classpath.txt
docker run "${consumer_args[@]}" --network none "$image" bash -c 'java -cp "target/classes:$(cat target/runtime-classpath.txt)" ConsumerKt'
