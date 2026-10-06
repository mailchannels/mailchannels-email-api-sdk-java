# Contributing

Keep generation reproducible. Update `codegen/` and run `bash scripts/regenerate.sh`;
do not hand-edit generated API/model files without updating the maintained source.
Generation uses a pinned OpenAPI Generator container and preserves the original wire
schema except explicit operation names and the reviewed 64-bit batch-ID hint.

Use Docker on Linux. Install Python PyYAML 6.0.3 and cryptography 45.0.3 for generation
and ephemeral TLS fixtures. Run the scripts documented in README before committing.
`SDK_JAVA_IMAGE` selects a pinned Maven/JDK image; CI tests Java 11, 17, 21 and 25.
The fixture suites run with external networking disabled. Packaging and dependency
resolution require network access, but never MailChannels credentials.

Tests in `tests/java` are the maintained validation suite. Generated empty tests and
untested Gradle/SBT build files are deliberately excluded. Source and Javadoc JARs
are checked against the complete maintained source tree. Kotlin consumption uses
only the installed artifact, without SDK source mounted into the consumer.

This repository has no automatic publication job. Do not add credentials to commits.
Central publisher setup, signing, release review and registry-install verification
must be completed before claiming Maven Central availability.
