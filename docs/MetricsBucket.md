

# MetricsBucket

Represents a time-based bucket for aggregating metrics data. Each bucket corresponds to a specific time interval, with the `period_start` indicating the beginning of that interval. The `count` field represents the number of events or occurrences that fall within that time period. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**count** | **Integer** | The number of events or occurrences aggregated within this time period. |  |
|**periodStart** | **OffsetDateTime** | The starting date and time of the time period this bucket represents. |  |



