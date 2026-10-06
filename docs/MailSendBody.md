

# MailSendBody


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**attachments** | [**List&lt;Attachment&gt;**](Attachment.md) |  |  [optional] |
|**campaignId** | **String** | The campaign identifier. If specified, this ID will be included in all relevant webhooks. It can be up to 48 UTF-8 characters long and must not contain spaces.  |  [optional] |
|**content** | [**List&lt;ContentItem&gt;**](ContentItem.md) |  |  |
|**dkimDomain** | **String** | If set, you must also provide the matching dkim_selector.  |  [optional] |
|**dkimPrivateKey** | **String** | Encoded in Base64. If set, you must also provide the matching dkim_domain and dkim_selector.  |  [optional] |
|**dkimSelector** | **String** | If set without a matching dkim_domain, the domain will be taken from the &#x60;from&#x60; email address.  |  [optional] |
|**envelopeFrom** | [**EmailAddress**](EmailAddress.md) |  |  [optional] |
|**from** | [**EmailAddress**](EmailAddress.md) |  |  |
|**headers** | **Map&lt;String, String&gt;** | A JSON object containing key-value pairs, where both keys (header names) and values must be strings. These pairs represent custom headers to be substituted. Please note the following restrictions and behavior: - Reserved headers: The following headers cannot be modified:   - Authentication-Results   - BCC   - CC   - Content-Transfer-Encoding   - Content-Type   - DKIM-Signature   - From   - Message-ID   - Received   - Reply-To   - Subject   - To - Header precedence: If a header is defined in both the personalizations object and the root headers, the value from personalizations will be used. - Case sensitivity: Headers are treated as case-insensitive. If multiple headers differ only by case, only one will be used, with no guarantee of which one.  |  [optional] |
|**personalizations** | [**List&lt;Personalization&gt;**](Personalization.md) |  |  |
|**replyTo** | [**EmailAddress**](EmailAddress.md) |  |  [optional] |
|**subject** | **String** |  |  |
|**trackingSettings** | [**MailSendBodyTrackingSettings**](MailSendBodyTrackingSettings.md) |  |  [optional] |
|**transactional** | **Boolean** | Mark these messages as transactional or non-transactional. In order for a message to be marked as non-transactional, it must have exactly one recipient per personalization, and it must be DKIM signed. 400 Bad Request will be returned if there are more than one recipient in any personalization for non-transactional messages. If a message is marked as non-transactional, it changes the sending process as follows:   * List-Unsubscribe and List-Unsubscribe-Post headers will be added, unless you supply your own List-Unsubscribe header, in which case yours is used and neither is added.  |  [optional] |
|**unsubscribeSettings** | [**MailSendBodyUnsubscribeSettings**](MailSendBodyUnsubscribeSettings.md) |  |  [optional] |



