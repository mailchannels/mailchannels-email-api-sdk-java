

# SpfResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**reason** | **String** | A human-readable explanation of SPF check.  |  [optional] |
|**spfRecord** | **String** | The SPF record that was used for the check.  |  [optional] |
|**spfRecordError** | **String** | Error message if the SPF record lookup failed.  |  [optional] |
|**verdict** | [**VerdictEnum**](#VerdictEnum) |  |  [optional] |



## Enum: VerdictEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;passed&quot; |
| FAILED | &quot;failed&quot; |
| SOFT_FAILED | &quot;soft failed&quot; |
| TEMPORARY_ERROR | &quot;temporary error&quot; |
| PERMANENT_ERROR | &quot;permanent error&quot; |
| NEUTRAL | &quot;neutral&quot; |
| NONE | &quot;none&quot; |
| UNKNOWN | &quot;unknown&quot; |



