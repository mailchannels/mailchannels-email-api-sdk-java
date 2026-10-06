

# Personalization


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**bcc** | [**List&lt;EmailAddress&gt;**](EmailAddress.md) |  |  [optional] |
|**cc** | [**List&lt;EmailAddress&gt;**](EmailAddress.md) |  |  [optional] |
|**dkimDomain** | **String** | If set, you must also provide the matching dkim_selector.  |  [optional] |
|**dkimPrivateKey** | **String** | Encoded in Base64. If set, you must also provide the matching dkim_domain and dkim_selector.  |  [optional] |
|**dkimSelector** | **String** | If set without a matching dkim_domain, the domain will be taken from the &#x60;from&#x60; email address.  |  [optional] |
|**dynamicTemplateData** | **Object** | A JSON object containing key-value pairs of variables to set for template rendering. Keys must be strings, and values can be one of the following types: * string * boolean * number * list, whose values are all of permitted types * map, whose keys must be strings, and whose values are all of permitted types  |  [optional] |
|**envelopeFrom** | [**EmailAddress**](EmailAddress.md) |  |  [optional] |
|**from** | [**EmailAddress**](EmailAddress.md) |  |  [optional] |
|**headers** | **Map&lt;String, String&gt;** | A JSON object containing key-value pairs, where both keys (header names) and values must be strings. These pairs represent custom headers to be substituted. Please note the following restrictions and behavior: - Reserved headers: The following headers cannot be modified:   - Authentication-Results   - BCC   - CC   - Content-Transfer-Encoding   - Content-Type   - DKIM-Signature   - From   - Message-ID   - Received   - Reply-To   - Subject   - To - Header precedence: If a header is defined in both the personalizations object and the root headers, the value from personalizations will be used. - Case sensitivity: Headers are treated as case-insensitive. If multiple headers differ only by case, only one will be used, with no guarantee of which one.  |  [optional] |
|**replyTo** | [**EmailAddress**](EmailAddress.md) |  |  [optional] |
|**subject** | **String** |  |  [optional] |
|**to** | [**List&lt;EmailAddress&gt;**](EmailAddress.md) |  |  |



