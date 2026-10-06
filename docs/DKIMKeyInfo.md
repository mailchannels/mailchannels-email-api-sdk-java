

# DKIMKeyInfo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**algorithm** | **String** | Algorithm used for the key pair  |  |
|**createdAt** | **OffsetDateTime** | Timestamp when the key pair was created  |  [optional] |
|**dkimDnsRecords** | [**List&lt;DKIMDnsRecord&gt;**](DKIMDnsRecord.md) | Suggested DNS records for the DKIM key  |  [optional] |
|**domain** | **String** | Domain associated with the key pair  |  |
|**gracePeriodExpiresAt** | **OffsetDateTime** | UTC timestamp after which you can no longer use the rotated key for signing  |  [optional] |
|**keyLength** | **Integer** | Key length in bits  |  [optional] |
|**publicKey** | **String** |  |  |
|**retiresAt** | **OffsetDateTime** | UTC timestamp when a rotated key pair is retired  |  [optional] |
|**selector** | **String** | Selector assigned to the key pair  |  |
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**statusModifiedAt** | **OffsetDateTime** | Timestamp when the key was last modified  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| RETIRED | &quot;retired&quot; |
| REVOKED | &quot;revoked&quot; |
| ROTATED | &quot;rotated&quot; |



