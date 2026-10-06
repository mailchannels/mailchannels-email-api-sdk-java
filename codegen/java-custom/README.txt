Java native response corrections

The pinned generator selects one success model for an operation. /send has a
200 Message and a 202 SendResults response; tracking create/update have active
CustomTrackingDomain and 202 DnsSetupRequired responses. The uncorrected client
silently drops 202 send results and decodes DNS setup as the wrong model.

fix-java-responses.py runs immediately after Java generation. It asserts the
expected pinned decoding statement, changes only the affected operation method
sections to typed response wrappers, and copies these maintained classes. It
fails if upstream generation changes rather than silently skipping a fix.
No wire schema is changed. Regenerated API docs still require release editing.

SendEmailResult: getDryRun() for 200, getAccepted() for 202.
CreateTrackingResult: getCreated() for 201, getAccepted() for 202.
UpdateTrackingResult: getUpdated() for 200, getAccepted() for 202.
Other accessors return null. getUnknown() retains JSON for undocumented success
statuses. Status remains available in both wrapper and ApiResponse; a truly
empty response may have null ApiResponse data. Malformed nonempty JSON throws.
These API class changes also decode response bytes explicitly as UTF-8.
Wrapper ToString is redacted; explicit models/JSON remain accessible. Generated model/exception diagnostics are now redacted by fix-java-diagnostics.py; transport defaults still need review.

Nine actual loopback HTTP checks pass on JDK 21 with external networking disabled:
202 partial send results, UTF-8 200 dry-run, empty/malformed/unknown success, and
both create/update tracking response statuses. Other endpoint/runtime/Kotlin
validation, licensing/package metadata and release work remain.

Diagnostics: 71 structured-model ToString methods now print type/redaction markers.
ApiException.getMessage/getCause suppress raw details in ordinary formatting and
stack traces; getRawMessage/getRawCause preserve explicit access alongside
response body/headers. Caller-added suppressed exceptions or explicit raw logging
are outside this guarantee. Three regressions cover model/key formatting, HTTP
error data, and nested cause formatting while verifying explicit data retention.
