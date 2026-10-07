# MailChannels Email API SDK for Java and Kotlin

Unreleased candidate: `com.mailchannels:mailchannels-email-api:0.1.0-SNAPSHOT`.
This artifact is not published to Maven Central. Publisher verification and release
review are pending. Support and maintenance: dev@mailchannels.com.

The SDK implements all 42 operations in the MailChannels Email API 1.7.1 schema.
Local fixture checks pass on Linux x64 Temurin 11, 17, 21 and 25; a Kotlin 2.2.21
consumer also passes on Java 11 and 21. These checks do not establish live provider conformance.

## Usage

After obtaining the reviewed artifact, construct `new ApiClient()` and pass it to
an API class such as `new SendApi(client)`. The default endpoint is
`https://api.mailchannels.net/tx/v1`. Obtain the API key from your secret manager
and supply it to the method's `xApiKey` argument. Never embed it in source.

`sendEmail(key, body, true)` requests provider dry-run validation. It still makes
an authenticated provider request. The repository's local fixture probes use no
provider credentials and send no email. Only use actual recipients with permission.

Send results are selected by HTTP status:

- HTTP 200: `SendEmailResult.getDryRun()` returns `Message`.
- HTTP 202: `getAccepted()` returns `SendResults`, including per-recipient results.
- Other success statuses: `getUnknown()` retains raw JSON for explicit inspection.

Nonmatching typed getters return null. An empty response can have null API response
data; malformed nonempty JSON fails. In Kotlin, check optional collections with
`requireNotNull` or safe calls before using them. Tracking-domain create/update use
`CreateTrackingResult` and `UpdateTrackingResult` for active versus DNS-pending results.

See [SendApi](docs/SendApi.md), [CustomTrackingApi](docs/CustomTrackingApi.md), and the
remaining generated API/model references in `docs/`. Generated examples illustrate
method signatures; supply valid account data before making any real API request.

## Transport and diagnostics

The default client uses platform TLS verification, no redirects, a 10-second
connection timeout and a 30-second deadline covering complete response receipt.
The deadline excludes JSON parsing and caller interceptors. Responses are buffered
in memory without an SDK size cap. Set custom timeouts before constructing API
instances; they capture client settings. An explicit null read timeout disables
the response deadline. Custom HttpClient builders can change TLS, redirects and
connection settings. Retain HTTPS and certificate verification in production.

Calls entered with the thread interrupt flag already set are rejected before
transport dispatch; generated API methods restore the flag and expose
`InterruptedException` as the `ApiException` cause. Interruption racing with
dispatch is still subject to the runtime limitations below.

Stalled HTTP/1.1 body cancellation and interrupt-flag preservation are tested on
Java 11/17/21/25. Before response headers arrive, deadline cancellation closes the
HTTP/1.1 peer connection on all four tested runtimes. Caller interruption closes
it on Java 17/21/25, but **Java 11 leaves the peer connection open during the
three-second observation window**, even though the caller returns with its interrupt
flag restored. Do not assume interrupting a Java 11 call aborts network activity.
A separate interruption-plus-deadline probe on Java 11.0.32.1 confirmed peer
closure after about two seconds with a two-second request deadline, even though
the caller had already returned on interruption. Retain a finite response deadline;
disabling it removes that expiry safeguard. This bounds the observed lingering
connection; it does not provide prompt cancellation or prove a send was unaccepted.
OpenJDK tracks the older cancellation behavior in
[JDK-8245462](https://bugs.openjdk.org/browse/JDK-8245462), fixed in Java 16.
Resolve this Java 11 behavior in release review before production use.
HTTP/2, other OS/JDKs, Android and other Kotlin versions remain unvalidated. Do not retry send operations blindly: a transport
failure does not establish whether the provider accepted a request.

Model `toString()` and routine `ApiException` formatting redact values. Explicit
serialization, getters, `getRawMessage()`, `getRawCause()`, response headers and
response bodies expose original data. Review them before logging. Caller-defined
interceptors and exceptions are outside SDK diagnostic redaction.

## Build and release status

Build with `mvn -Dmaven.test.skip=true package`. Generated placeholder tests are
not the validation suite. Run `bash scripts/test.sh`, `bash scripts/kotlin.sh`, `bash scripts/docs.sh`,
`bash scripts/pack.sh` and `bash scripts/audit.sh` before release. Reproduce sources
with `bash scripts/regenerate.sh`; it requires Docker and Python PyYAML 6.0.3.
TLS tests require Python cryptography. CI checks all four Java runtimes. Jackson core/databind/jsr310 are pinned to 2.21.7;
the recorded OSV audit covers resolved SDK dependencies, not build tools or the JDK.

MIT license. No automated publication is configured in this candidate.
