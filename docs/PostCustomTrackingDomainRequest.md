

# PostCustomTrackingDomainRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**hostname** | **String** | The hostname to register as a custom tracking domain (e.g., click.example.com). The hostname must have a CNAME record pointing to &#x60;links.mailchannels.net&#x60;.  |  |
|**name** | **String** | A unique label used to select this domain at message send time |  |
|**scope** | [**ScopeEnum**](#ScopeEnum) | The event type this domain handles |  |



## Enum: ScopeEnum

| Name | Value |
|---- | -----|
| CLICK | &quot;click&quot; |
| OPEN | &quot;open&quot; |
| UNSUBSCRIBE | &quot;unsubscribe&quot; |



