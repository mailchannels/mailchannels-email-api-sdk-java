

# SuppressionEntryResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdAt** | **OffsetDateTime** |  |  [optional] |
|**notes** | **String** |  |  [optional] |
|**recipient** | **String** |  |  |
|**sender** | **String** |  |  [optional] |
|**source** | [**SourceEnum**](#SourceEnum) |  |  [optional] |
|**suppressionTypes** | [**List&lt;SuppressionTypesEnum&gt;**](#List&lt;SuppressionTypesEnum&gt;) |  |  [optional] |



## Enum: SourceEnum

| Name | Value |
|---- | -----|
| API | &quot;api&quot; |
| UNSUBSCRIBE_LINK | &quot;unsubscribe_link&quot; |
| LIST_UNSUBSCRIBE | &quot;list_unsubscribe&quot; |
| HARD_BOUNCE | &quot;hard_bounce&quot; |
| SPAM_COMPLAINT | &quot;spam_complaint&quot; |



## Enum: List&lt;SuppressionTypesEnum&gt;

| Name | Value |
|---- | -----|
| TRANSACTIONAL | &quot;transactional&quot; |
| NON_TRANSACTIONAL | &quot;non-transactional&quot; |



