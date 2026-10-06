

# DnsSetupRequired


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**instructions** | **String** | Human-readable guidance for the DNS records that must be in place before retrying. |  [optional] |
|**token** | **String** | UUID v4 nonce; also the TXT record value to set. Present only when TXT ownership verification is pending. |  [optional] |
|**txtRecordName** | **String** | Fully-qualified DNS TXT record name to add. Present only when TXT ownership verification is pending. |  [optional] |
|**txtRecordValue** | **String** | Value for the DNS TXT record (same as token). Present only when TXT ownership verification is pending. |  [optional] |



