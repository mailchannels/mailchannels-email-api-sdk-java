

# DkimResult


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**dkimDomain** | **String** |  |  [optional] |
|**dkimKeyStatus** | **String** | The human readable status of the DKIM key used for verification. This field is only present if the DKIM check was performed using a DKIM key managed by MailChannels. If a DKIM key is present in the request, this field will not be included.  |  [optional] |
|**dkimSelector** | **String** |  |  [optional] |
|**reason** | **String** | A human-readable explanation of DKIM check. |  [optional] |
|**verdict** | [**VerdictEnum**](#VerdictEnum) |  |  [optional] |



## Enum: VerdictEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;passed&quot; |
| FAILED | &quot;failed&quot; |



