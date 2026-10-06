

# SenderDomainResult

These results are here to help avoid SDNF (Sender Domain Not Found) blocks. For messages not to get blocked by [SDNF](https://support.mailchannels.com/hc/en-us/articles/203155500-550-5-2-1-SDNF-Sender-Domain-Not-Found), we require either an MX or A record to exist for the sender domain. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**a** | [**SenderDomainResultA**](SenderDomainResultA.md) |  |  [optional] |
|**mx** | [**SenderDomainResultMx**](SenderDomainResultMx.md) |  |  [optional] |
|**verdict** | [**VerdictEnum**](#VerdictEnum) | Overall verdict. Passed if either A or MX record check passed. |  [optional] |



## Enum: VerdictEnum

| Name | Value |
|---- | -----|
| PASSED | &quot;passed&quot; |
| FAILED | &quot;failed&quot; |



