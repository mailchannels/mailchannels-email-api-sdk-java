

# DKIMKeyPairCreateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**algorithm** | [**AlgorithmEnum**](#AlgorithmEnum) | Algorithm used for the new key pair Currently, only RSA is supported.  |  [optional] |
|**keyLength** | **Integer** | Key length in bits. For RSA, must be a multiple of 1024. Common values: 1024 or 2048. Defaults to 2048 bits.  |  [optional] |
|**selector** | **String** | Selector for the new key pair  |  |



## Enum: AlgorithmEnum

| Name | Value |
|---- | -----|
| RSA | &quot;rsa&quot; |



