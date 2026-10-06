

# WebhookResendResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**batchId** | **Long** | Unique identifier for the webhook batch  |  |
|**createdAt** | **OffsetDateTime** | Timestamp of when the webhook batch was created |  |
|**customerHandle** | **String** | Customer handle associated with the webhook batch |  |
|**durationInMs** | **Integer** | Duration of the webhook batch in milliseconds, measured from the time the request was sent to the webhook endpoint until the response was received. Null indicates that no response was returned from the webhook endpoint.  |  [optional] |
|**eventCount** | **Integer** | Number of events in the webhook batch |  |
|**statusCode** | **Integer** | HTTP status code returned by the webhook endpoint. Valid values are 100-599. Null indicates that no response was returned from the webhook endpoint.  |  [optional] |
|**webhook** | **String** | Webhook URL to which events in the batch were posted |  |



