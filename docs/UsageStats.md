

# UsageStats


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**monthlyLimit** | **Integer** | The effective monthly limit for the current billing period. A limit of zero means the account cannot send any messages. For sub-accounts with no explicit limit set (i.e., -1), the monthly limit for the parent account is returned.  |  |
|**periodEndDate** | **LocalDate** | The end date of the current billing period (ISO 8601 format). |  [optional] |
|**periodStartDate** | **LocalDate** | The start date of the current billing period (ISO 8601 format). |  [optional] |
|**totalUsage** | **Long** | The total usage for the current billing period. |  |



