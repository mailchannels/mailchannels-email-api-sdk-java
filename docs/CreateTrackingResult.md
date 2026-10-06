# CreateTrackingResult

Status-specific response wrapper. getCreated(): HTTP 201 CustomTrackingDomain; getAccepted(): HTTP 202 DnsSetupRequired.

Nonmatching typed getters return null. getStatusCode() retains the HTTP status.
getUnknown() retains JSON for undocumented success statuses. Empty responses can
have null data. Routine toString() is redacted; explicit getters expose data.
