

# WebhookBatch


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**batchId** | **Long** | Unique identifier for the webhook batch  |  |
|**createdAt** | **OffsetDateTime** | Timestamp of when the webhook batch was created  |  |
|**customerHandle** | **String** | Customer handle associated with the webhook batch  |  |
|**duration** | [**WebhookBatchDuration**](WebhookBatchDuration.md) |  |  [optional] |
|**eventCount** | **Integer** | Number of events in the webhook batch  |  |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the webhook batch. no_response: no response returned from the webhook endpoint.  |  |
|**statusCode** | **Integer** | HTTP status code returned by the webhook endpoint  |  [optional] |
|**webhook** | **String** | Webhook endpoint to which events in the batch were posted |  |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| _1XX_RESPONSE | &quot;1xx_response&quot; |
| _2XX_RESPONSE | &quot;2xx_response&quot; |
| _3XX_RESPONSE | &quot;3xx_response&quot; |
| _4XX_RESPONSE | &quot;4xx_response&quot; |
| _5XX_RESPONSE | &quot;5xx_response&quot; |
| NO_RESPONSE | &quot;no_response&quot; |



