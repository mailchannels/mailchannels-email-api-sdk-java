

# WebhookValidationResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**response** | [**WebhookResponse**](WebhookResponse.md) |  |  |
|**result** | [**ResultEnum**](#ResultEnum) | Indicates whether the webhook responded with a 2xx HTTP status code  |  |
|**webhook** | **String** | The webhook that was validated  |  |



## Enum: ResultEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;passed&quot; |
| FAILED | &quot;failed&quot; |



