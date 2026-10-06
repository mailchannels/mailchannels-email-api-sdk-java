

# CustomTrackingDomain


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdAt** | **OffsetDateTime** | ISO 8601 timestamp when the domain was registered |  |
|**hostname** | **String** | The registered domain hostname |  |
|**name** | **String** | The label for this custom tracking domain |  |
|**scope** | [**ScopeEnum**](#ScopeEnum) | The event type this domain handles |  |
|**status** | [**StatusEnum**](#StatusEnum) | Current status of the custom tracking domain |  |



## Enum: ScopeEnum

| Name | Value |
|---- | -----|
| CLICK | &quot;click&quot; |
| OPEN | &quot;open&quot; |
| UNSUBSCRIBE | &quot;unsubscribe&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| DISABLED | &quot;disabled&quot; |



