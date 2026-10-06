

# WebhookResponse

The HTTP response returned by the webhook, including status code and response body. A null value indicates no response was received. Possible reasons include timeouts, connection failures, or other network-related issues. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**body** | **String** | Response body from webhook. Returns an error if unprocessable or too large.  |  [optional] |
|**status** | **Integer** | HTTP status code returned by the webhook  |  |



