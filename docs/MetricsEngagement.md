

# MetricsEngagement


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**buckets** | [**MetricsEngagementBuckets**](MetricsEngagementBuckets.md) |  |  |
|**click** | **Integer** | Count of click events by recipients.  |  |
|**clickTrackingDelivered** | **Integer** | Count of recipients of delivered messages with HTML content that contains tracked click URLs, where click tracking is enabled in the send request.  |  |
|**endTime** | **OffsetDateTime** | The end of the time range for retrieving message engagement metrics (exclusive).  |  [optional] |
|**open** | **Integer** | Count of open events by recipients.  |  |
|**openTrackingDelivered** | **Integer** | Count of recipients of delivered messages with HTML content where open tracking was enabled in the send request.  |  |
|**startTime** | **OffsetDateTime** | The beginning of the time range for retrieving message engagement metrics (inclusive).  |  [optional] |
|**uniqueClick** | **Integer** | Count of distinct messages that had at least one click event. Unlike &#x60;click&#x60;, each message is counted at most once regardless of how many links were clicked or how many times. Use this to compute click rates without exceeding 100%.  |  [optional] |
|**uniqueClickTrackingDelivered** | **Integer** | Count of distinct messages delivered with click tracking enabled (message-level, not recipient-level). Use as the denominator when computing unique click rates.  |  [optional] |
|**uniqueOpen** | **Integer** | Count of distinct messages that had at least one open event. Unlike &#x60;open&#x60;, each message is counted at most once regardless of how many times its tracking pixel was fired. Use this to compute open rates without exceeding 100%.  |  [optional] |
|**uniqueOpenTrackingDelivered** | **Integer** | Count of distinct messages delivered with open tracking enabled (message-level, not recipient-level). Use as the denominator when computing unique open rates.  |  [optional] |



