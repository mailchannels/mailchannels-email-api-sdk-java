

# SuppressionListInput


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addToSubAccounts** | **Boolean** | If true, the parent account creates suppression entries for all associated sub-accounts. This field is only applicable to parent accounts. Sub-accounts cannot create entries for other sub-accounts.  |  [optional] |
|**suppressionEntries** | [**List&lt;SuppressionEntry&gt;**](SuppressionEntry.md) | The total number of suppression entries to create, for the parent and/or its sub-accounts, must not exceed 1000. |  |



