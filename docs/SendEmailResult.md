# SendEmailResult

Status-specific response wrapper. getDryRun(): HTTP 200 Message; getAccepted(): HTTP 202 SendResults.

Nonmatching typed getters return null. getStatusCode() retains the HTTP status.
getUnknown() retains JSON for undocumented success statuses. Empty responses can
have null data. Routine toString() is redacted; explicit getters expose data.
