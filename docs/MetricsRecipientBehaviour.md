

# MetricsRecipientBehaviour


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**buckets** | [**MetricsRecipientBehaviourBuckets**](MetricsRecipientBehaviourBuckets.md) |  |  |
|**endTime** | **OffsetDateTime** | The end of the time range for retrieving recipient behaviour metrics (exclusive).  |  [optional] |
|**startTime** | **OffsetDateTime** | The beginning of the time range for retrieving recipient behaviour metrics (inclusive).  |  [optional] |
|**unsubscribeDelivered** | **Integer** | Count of recipients of delivered messages that include at least one of the unsubscribe link or unsubscribe headers. Since the unsubscribe feature requires exactly one recipient per message, this count also represents the total number of delivered messages.  |  |
|**unsubscribed** | **Integer** | Count of unsubscribed events by recipients.  |  |



