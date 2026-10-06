# SubAccountsApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**activateSubaccount**](SubAccountsApi.md#activateSubaccount) | **POST** /sub-account/{handle}/activate | Activate Sub-account |
| [**activateSubaccountWithHttpInfo**](SubAccountsApi.md#activateSubaccountWithHttpInfo) | **POST** /sub-account/{handle}/activate | Activate Sub-account |
| [**createSubaccount**](SubAccountsApi.md#createSubaccount) | **POST** /sub-account | Create Sub-account |
| [**createSubaccountWithHttpInfo**](SubAccountsApi.md#createSubaccountWithHttpInfo) | **POST** /sub-account | Create Sub-account |
| [**createSubaccountApiKey**](SubAccountsApi.md#createSubaccountApiKey) | **POST** /sub-account/{handle}/api-key | Create Sub-account API Key |
| [**createSubaccountApiKeyWithHttpInfo**](SubAccountsApi.md#createSubaccountApiKeyWithHttpInfo) | **POST** /sub-account/{handle}/api-key | Create Sub-account API Key |
| [**createSubaccountSmtpPassword**](SubAccountsApi.md#createSubaccountSmtpPassword) | **POST** /sub-account/{handle}/smtp-password | Create Sub-account SMTP Password |
| [**createSubaccountSmtpPasswordWithHttpInfo**](SubAccountsApi.md#createSubaccountSmtpPasswordWithHttpInfo) | **POST** /sub-account/{handle}/smtp-password | Create Sub-account SMTP Password |
| [**deleteSubaccount**](SubAccountsApi.md#deleteSubaccount) | **DELETE** /sub-account/{handle} | Delete Sub-account |
| [**deleteSubaccountWithHttpInfo**](SubAccountsApi.md#deleteSubaccountWithHttpInfo) | **DELETE** /sub-account/{handle} | Delete Sub-account |
| [**deleteSubaccountApiKey**](SubAccountsApi.md#deleteSubaccountApiKey) | **DELETE** /sub-account/{handle}/api-key/{id} | Delete Sub-account API Key |
| [**deleteSubaccountApiKeyWithHttpInfo**](SubAccountsApi.md#deleteSubaccountApiKeyWithHttpInfo) | **DELETE** /sub-account/{handle}/api-key/{id} | Delete Sub-account API Key |
| [**deleteSubaccountLimit**](SubAccountsApi.md#deleteSubaccountLimit) | **DELETE** /sub-account/{handle}/limit | Delete Sub-account Limit |
| [**deleteSubaccountLimitWithHttpInfo**](SubAccountsApi.md#deleteSubaccountLimitWithHttpInfo) | **DELETE** /sub-account/{handle}/limit | Delete Sub-account Limit |
| [**deleteSubaccountSmtpPassword**](SubAccountsApi.md#deleteSubaccountSmtpPassword) | **DELETE** /sub-account/{handle}/smtp-password/{id} | Delete Sub-account SMTP Password |
| [**deleteSubaccountSmtpPasswordWithHttpInfo**](SubAccountsApi.md#deleteSubaccountSmtpPasswordWithHttpInfo) | **DELETE** /sub-account/{handle}/smtp-password/{id} | Delete Sub-account SMTP Password |
| [**getSubaccountLimit**](SubAccountsApi.md#getSubaccountLimit) | **GET** /sub-account/{handle}/limit | Retrieve Sub-account Limit |
| [**getSubaccountLimitWithHttpInfo**](SubAccountsApi.md#getSubaccountLimitWithHttpInfo) | **GET** /sub-account/{handle}/limit | Retrieve Sub-account Limit |
| [**getSubaccountUsage**](SubAccountsApi.md#getSubaccountUsage) | **GET** /sub-account/{handle}/usage | Retrieve Sub-account Usage Stats |
| [**getSubaccountUsageWithHttpInfo**](SubAccountsApi.md#getSubaccountUsageWithHttpInfo) | **GET** /sub-account/{handle}/usage | Retrieve Sub-account Usage Stats |
| [**listSubaccountApiKeys**](SubAccountsApi.md#listSubaccountApiKeys) | **GET** /sub-account/{handle}/api-key | Retrieve Sub-account API Keys |
| [**listSubaccountApiKeysWithHttpInfo**](SubAccountsApi.md#listSubaccountApiKeysWithHttpInfo) | **GET** /sub-account/{handle}/api-key | Retrieve Sub-account API Keys |
| [**listSubaccountSmtpPasswords**](SubAccountsApi.md#listSubaccountSmtpPasswords) | **GET** /sub-account/{handle}/smtp-password | Retrieve Sub-account SMTP Passwords |
| [**listSubaccountSmtpPasswordsWithHttpInfo**](SubAccountsApi.md#listSubaccountSmtpPasswordsWithHttpInfo) | **GET** /sub-account/{handle}/smtp-password | Retrieve Sub-account SMTP Passwords |
| [**listSubaccounts**](SubAccountsApi.md#listSubaccounts) | **GET** /sub-account | Retrieve Sub-accounts |
| [**listSubaccountsWithHttpInfo**](SubAccountsApi.md#listSubaccountsWithHttpInfo) | **GET** /sub-account | Retrieve Sub-accounts |
| [**setSubaccountLimit**](SubAccountsApi.md#setSubaccountLimit) | **PUT** /sub-account/{handle}/limit | Set Sub-account Limit |
| [**setSubaccountLimitWithHttpInfo**](SubAccountsApi.md#setSubaccountLimitWithHttpInfo) | **PUT** /sub-account/{handle}/limit | Set Sub-account Limit |
| [**suspendSubaccount**](SubAccountsApi.md#suspendSubaccount) | **POST** /sub-account/{handle}/suspend | Suspend Sub-account |
| [**suspendSubaccountWithHttpInfo**](SubAccountsApi.md#suspendSubaccountWithHttpInfo) | **POST** /sub-account/{handle}/suspend | Suspend Sub-account |



## activateSubaccount

> void activateSubaccount(handle, xApiKey)

Activate Sub-account

Activates a suspended sub-account identified by its handle, restoring its ability to send emails. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of sub-account to be activated.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.activateSubaccount(handle, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#activateSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of sub-account to be activated. | |
| **xApiKey** | **String**|  | |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified sub-account is successfully activated. |  -  |
| **403** | The operation is forbidden. The parent account does not have permission to activate the sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## activateSubaccountWithHttpInfo

> ApiResponse<Void> activateSubaccountWithHttpInfo(handle, xApiKey)

Activate Sub-account

Activates a suspended sub-account identified by its handle, restoring its ability to send emails. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of sub-account to be activated.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.activateSubaccountWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#activateSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of sub-account to be activated. | |
| **xApiKey** | **String**|  | |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified sub-account is successfully activated. |  -  |
| **403** | The operation is forbidden. The parent account does not have permission to activate the sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## createSubaccount

> SubAccountDetails createSubaccount(xApiKey, subAccountData)

Create Sub-account

Creates a new sub-account under the parent account. Each sub-account must have a unique handle composed solely of lowercase alphanumeric characters. If no handle is provided, a random handle will be generated. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        SubAccountData subAccountData = new SubAccountData(); // SubAccountData | The details of the sub-account to create.
        try {
            SubAccountDetails result = apiInstance.createSubaccount(xApiKey, subAccountData);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#createSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xApiKey** | **String**|  | |
| **subAccountData** | [**SubAccountData**](SubAccountData.md)| The details of the sub-account to create. | [optional] |

### Return type

[**SubAccountDetails**](SubAccountDetails.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The sub-account was successfully created. |  -  |
| **400** | Malformed request. The request body is invalid. |  -  |
| **403** | The operation is forbidden. The parent account does not have permission to create sub-accounts. |  -  |
| **409** | A sub-account with the specified name already exists. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## createSubaccountWithHttpInfo

> ApiResponse<SubAccountDetails> createSubaccountWithHttpInfo(xApiKey, subAccountData)

Create Sub-account

Creates a new sub-account under the parent account. Each sub-account must have a unique handle composed solely of lowercase alphanumeric characters. If no handle is provided, a random handle will be generated. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        SubAccountData subAccountData = new SubAccountData(); // SubAccountData | The details of the sub-account to create.
        try {
            ApiResponse<SubAccountDetails> response = apiInstance.createSubaccountWithHttpInfo(xApiKey, subAccountData);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#createSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xApiKey** | **String**|  | |
| **subAccountData** | [**SubAccountData**](SubAccountData.md)| The details of the sub-account to create. | [optional] |

### Return type

ApiResponse<[**SubAccountDetails**](SubAccountDetails.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The sub-account was successfully created. |  -  |
| **400** | Malformed request. The request body is invalid. |  -  |
| **403** | The operation is forbidden. The parent account does not have permission to create sub-accounts. |  -  |
| **409** | A sub-account with the specified name already exists. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## createSubaccountApiKey

> APIKey createSubaccountApiKey(handle, xApiKey)

Create Sub-account API Key

Creates a new API key for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to create API key for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            APIKey result = apiInstance.createSubaccountApiKey(handle, xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#createSubaccountApiKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to create API key for. | |
| **xApiKey** | **String**|  | |

### Return type

[**APIKey**](APIKey.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | A new API key was successfully created for the specified sub-account.  |  -  |
| **403** | The operation is forbidden. You can&#39;t create API keys for this sub-account.  |  -  |
| **404** | The specified sub-account does not exist.  |  -  |
| **422** | You have reached the limit of API keys you can create for this sub-account.  |  -  |
| **500** | An unexpected internal error occurred.  |  -  |

## createSubaccountApiKeyWithHttpInfo

> ApiResponse<APIKey> createSubaccountApiKeyWithHttpInfo(handle, xApiKey)

Create Sub-account API Key

Creates a new API key for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to create API key for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<APIKey> response = apiInstance.createSubaccountApiKeyWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#createSubaccountApiKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to create API key for. | |
| **xApiKey** | **String**|  | |

### Return type

ApiResponse<[**APIKey**](APIKey.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | A new API key was successfully created for the specified sub-account.  |  -  |
| **403** | The operation is forbidden. You can&#39;t create API keys for this sub-account.  |  -  |
| **404** | The specified sub-account does not exist.  |  -  |
| **422** | You have reached the limit of API keys you can create for this sub-account.  |  -  |
| **500** | An unexpected internal error occurred.  |  -  |


## createSubaccountSmtpPassword

> SMTPPassword createSubaccountSmtpPassword(handle, xApiKey)

Create Sub-account SMTP Password

Creates a new SMTP password for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to create SMTP password for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            SMTPPassword result = apiInstance.createSubaccountSmtpPassword(handle, xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#createSubaccountSmtpPassword");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to create SMTP password for. | |
| **xApiKey** | **String**|  | |

### Return type

[**SMTPPassword**](SMTPPassword.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | A new SMTP password was successfully created for the specified sub-account. |  -  |
| **403** | The operation is forbidden. You can&#39;t create SMTP passwords for this sub-account.  |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **422** | You have reached the limit of SMTP passwords you can create for this sub-account.  |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## createSubaccountSmtpPasswordWithHttpInfo

> ApiResponse<SMTPPassword> createSubaccountSmtpPasswordWithHttpInfo(handle, xApiKey)

Create Sub-account SMTP Password

Creates a new SMTP password for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to create SMTP password for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<SMTPPassword> response = apiInstance.createSubaccountSmtpPasswordWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#createSubaccountSmtpPassword");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to create SMTP password for. | |
| **xApiKey** | **String**|  | |

### Return type

ApiResponse<[**SMTPPassword**](SMTPPassword.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | A new SMTP password was successfully created for the specified sub-account. |  -  |
| **403** | The operation is forbidden. You can&#39;t create SMTP passwords for this sub-account.  |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **422** | You have reached the limit of SMTP passwords you can create for this sub-account.  |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## deleteSubaccount

> void deleteSubaccount(handle, xApiKey)

Delete Sub-account

Deletes the sub-account identified by its handle.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of sub-account to be deleted.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.deleteSubaccount(handle, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of sub-account to be deleted. | |
| **xApiKey** | **String**|  | |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified sub-account(s) were successfully deleted. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## deleteSubaccountWithHttpInfo

> ApiResponse<Void> deleteSubaccountWithHttpInfo(handle, xApiKey)

Delete Sub-account

Deletes the sub-account identified by its handle.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of sub-account to be deleted.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.deleteSubaccountWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of sub-account to be deleted. | |
| **xApiKey** | **String**|  | |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified sub-account(s) were successfully deleted. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## deleteSubaccountApiKey

> void deleteSubaccountApiKey(handle, id, xApiKey)

Delete Sub-account API Key

Deletes the API key identified by its ID for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account for which the API key should be deleted. 
        Integer id = 56; // Integer | The ID of the API key to delete.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.deleteSubaccountApiKey(handle, id, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccountApiKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account for which the API key should be deleted.  | |
| **id** | **Integer**| The ID of the API key to delete. | |
| **xApiKey** | **String**|  | |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The API key was successfully deleted for the sub-account.  |  -  |
| **400** | Missing or invalid API key ID.  |  -  |
| **500** | An unexpected internal error occurred.  |  -  |

## deleteSubaccountApiKeyWithHttpInfo

> ApiResponse<Void> deleteSubaccountApiKeyWithHttpInfo(handle, id, xApiKey)

Delete Sub-account API Key

Deletes the API key identified by its ID for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account for which the API key should be deleted. 
        Integer id = 56; // Integer | The ID of the API key to delete.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.deleteSubaccountApiKeyWithHttpInfo(handle, id, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccountApiKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account for which the API key should be deleted.  | |
| **id** | **Integer**| The ID of the API key to delete. | |
| **xApiKey** | **String**|  | |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The API key was successfully deleted for the sub-account.  |  -  |
| **400** | Missing or invalid API key ID.  |  -  |
| **500** | An unexpected internal error occurred.  |  -  |


## deleteSubaccountLimit

> void deleteSubaccountLimit(handle, xApiKey)

Delete Sub-account Limit

Deletes the limit for the specified sub-account. After a successful deletion, the specified sub-account will be limited to the parent account&#39;s limit. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to delete limit for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.deleteSubaccountLimit(handle, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccountLimit");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to delete limit for. | |
| **xApiKey** | **String**|  | |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The limit was successfully deleted for the sub-account. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## deleteSubaccountLimitWithHttpInfo

> ApiResponse<Void> deleteSubaccountLimitWithHttpInfo(handle, xApiKey)

Delete Sub-account Limit

Deletes the limit for the specified sub-account. After a successful deletion, the specified sub-account will be limited to the parent account&#39;s limit. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to delete limit for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.deleteSubaccountLimitWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccountLimit");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to delete limit for. | |
| **xApiKey** | **String**|  | |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The limit was successfully deleted for the sub-account. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## deleteSubaccountSmtpPassword

> void deleteSubaccountSmtpPassword(handle, id, xApiKey)

Delete Sub-account SMTP Password

Deletes the SMTP password identified by its ID for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account for which the SMTP password should be deleted.
        Integer id = 56; // Integer | The ID of the SMTP password to delete.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.deleteSubaccountSmtpPassword(handle, id, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccountSmtpPassword");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account for which the SMTP password should be deleted. | |
| **id** | **Integer**| The ID of the SMTP password to delete. | |
| **xApiKey** | **String**|  | |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified SMTP password was successfully deleted for the sub-account. |  -  |
| **400** | Missing or invalid SMTP password ID. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## deleteSubaccountSmtpPasswordWithHttpInfo

> ApiResponse<Void> deleteSubaccountSmtpPasswordWithHttpInfo(handle, id, xApiKey)

Delete Sub-account SMTP Password

Deletes the SMTP password identified by its ID for the specified sub-account. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account for which the SMTP password should be deleted.
        Integer id = 56; // Integer | The ID of the SMTP password to delete.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.deleteSubaccountSmtpPasswordWithHttpInfo(handle, id, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#deleteSubaccountSmtpPassword");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account for which the SMTP password should be deleted. | |
| **id** | **Integer**| The ID of the SMTP password to delete. | |
| **xApiKey** | **String**|  | |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified SMTP password was successfully deleted for the sub-account. |  -  |
| **400** | Missing or invalid SMTP password ID. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## getSubaccountLimit

> Limit getSubaccountLimit(handle, xApiKey)

Retrieve Sub-account Limit

Retrieves the limit of a specified sub-account. A value of -1 indicates that the sub-account inherits the parent account&#39;s limit, allowing the sub-account to utilize any remaining capacity within the parent account&#39;s allocation. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to retrieve the limit for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            Limit result = apiInstance.getSubaccountLimit(handle, xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#getSubaccountLimit");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to retrieve the limit for. | |
| **xApiKey** | **String**|  | |

### Return type

[**Limit**](Limit.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved the limit for the specified sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## getSubaccountLimitWithHttpInfo

> ApiResponse<Limit> getSubaccountLimitWithHttpInfo(handle, xApiKey)

Retrieve Sub-account Limit

Retrieves the limit of a specified sub-account. A value of -1 indicates that the sub-account inherits the parent account&#39;s limit, allowing the sub-account to utilize any remaining capacity within the parent account&#39;s allocation. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to retrieve the limit for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Limit> response = apiInstance.getSubaccountLimitWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#getSubaccountLimit");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to retrieve the limit for. | |
| **xApiKey** | **String**|  | |

### Return type

ApiResponse<[**Limit**](Limit.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved the limit for the specified sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## getSubaccountUsage

> UsageStats getSubaccountUsage(handle, xApiKey)

Retrieve Sub-account Usage Stats

Retrieves usage statistics for the specified sub-account during the current billing period.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to query usage stats for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            UsageStats result = apiInstance.getSubaccountUsage(handle, xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#getSubaccountUsage");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to query usage stats for. | |
| **xApiKey** | **String**|  | |

### Return type

[**UsageStats**](UsageStats.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully returned the usage stats. |  -  |
| **404** | Sub-account not found |  -  |
| **500** | Internal Server Error |  -  |

## getSubaccountUsageWithHttpInfo

> ApiResponse<UsageStats> getSubaccountUsageWithHttpInfo(handle, xApiKey)

Retrieve Sub-account Usage Stats

Retrieves usage statistics for the specified sub-account during the current billing period.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to query usage stats for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<UsageStats> response = apiInstance.getSubaccountUsageWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#getSubaccountUsage");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to query usage stats for. | |
| **xApiKey** | **String**|  | |

### Return type

ApiResponse<[**UsageStats**](UsageStats.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully returned the usage stats. |  -  |
| **404** | Sub-account not found |  -  |
| **500** | Internal Server Error |  -  |


## listSubaccountApiKeys

> List<APIKey> listSubaccountApiKeys(handle, xApiKey, limit, offset)

Retrieve Sub-account API Keys

Retrieves details of all API keys associated with the specified sub-account. For security reasons, the full API key is **not** returned; only the key ID and a partially redacted version are provided. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to retrieve the API key for.
        String xApiKey = "xApiKey_example"; // String | 
        Integer limit = 100; // Integer | 
        Integer offset = 0; // Integer | 
        try {
            List<APIKey> result = apiInstance.listSubaccountApiKeys(handle, xApiKey, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#listSubaccountApiKeys");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to retrieve the API key for. | |
| **xApiKey** | **String**|  | |
| **limit** | **Integer**|  | [optional] [default to 100] |
| **offset** | **Integer**|  | [optional] [default to 0] |

### Return type

[**List&lt;APIKey&gt;**](APIKey.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved the API key for the specified sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## listSubaccountApiKeysWithHttpInfo

> ApiResponse<List<APIKey>> listSubaccountApiKeysWithHttpInfo(handle, xApiKey, limit, offset)

Retrieve Sub-account API Keys

Retrieves details of all API keys associated with the specified sub-account. For security reasons, the full API key is **not** returned; only the key ID and a partially redacted version are provided. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to retrieve the API key for.
        String xApiKey = "xApiKey_example"; // String | 
        Integer limit = 100; // Integer | 
        Integer offset = 0; // Integer | 
        try {
            ApiResponse<List<APIKey>> response = apiInstance.listSubaccountApiKeysWithHttpInfo(handle, xApiKey, limit, offset);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#listSubaccountApiKeys");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to retrieve the API key for. | |
| **xApiKey** | **String**|  | |
| **limit** | **Integer**|  | [optional] [default to 100] |
| **offset** | **Integer**|  | [optional] [default to 0] |

### Return type

ApiResponse<[**List&lt;APIKey&gt;**](APIKey.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved the API key for the specified sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## listSubaccountSmtpPasswords

> List<SMTPPassword> listSubaccountSmtpPasswords(handle, xApiKey)

Retrieve Sub-account SMTP Passwords

Retrieves details of all SMTP passwords associated with the specified sub-account. For security, the full SMTP password is **not** returned; only the password ID and a partially redacted version are provided. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to retrieve the SMTP password for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            List<SMTPPassword> result = apiInstance.listSubaccountSmtpPasswords(handle, xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#listSubaccountSmtpPasswords");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to retrieve the SMTP password for. | |
| **xApiKey** | **String**|  | |

### Return type

[**List&lt;SMTPPassword&gt;**](SMTPPassword.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved the SMTP password for the specified sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## listSubaccountSmtpPasswordsWithHttpInfo

> ApiResponse<List<SMTPPassword>> listSubaccountSmtpPasswordsWithHttpInfo(handle, xApiKey)

Retrieve Sub-account SMTP Passwords

Retrieves details of all SMTP passwords associated with the specified sub-account. For security, the full SMTP password is **not** returned; only the password ID and a partially redacted version are provided. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to retrieve the SMTP password for.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<List<SMTPPassword>> response = apiInstance.listSubaccountSmtpPasswordsWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#listSubaccountSmtpPasswords");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to retrieve the SMTP password for. | |
| **xApiKey** | **String**|  | |

### Return type

ApiResponse<[**List&lt;SMTPPassword&gt;**](SMTPPassword.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved the SMTP password for the specified sub-account. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## listSubaccounts

> List<SubAccountDetails> listSubaccounts(xApiKey, limit, offset)

Retrieve Sub-accounts

Retrieves all sub-accounts associated with the parent account. The response is paginated with a default limit of 1000 sub-accounts per page and an offset of 0. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        Integer limit = 1000; // Integer | 
        Integer offset = 0; // Integer | 
        try {
            List<SubAccountDetails> result = apiInstance.listSubaccounts(xApiKey, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#listSubaccounts");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xApiKey** | **String**|  | |
| **limit** | **Integer**|  | [optional] [default to 1000] |
| **offset** | **Integer**|  | [optional] [default to 0] |

### Return type

[**List&lt;SubAccountDetails&gt;**](SubAccountDetails.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved all sub-accounts associated with the parent account. |  -  |
| **400** | Bad Request. The limit and/or offset query parameter are invalid. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## listSubaccountsWithHttpInfo

> ApiResponse<List<SubAccountDetails>> listSubaccountsWithHttpInfo(xApiKey, limit, offset)

Retrieve Sub-accounts

Retrieves all sub-accounts associated with the parent account. The response is paginated with a default limit of 1000 sub-accounts per page and an offset of 0. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        Integer limit = 1000; // Integer | 
        Integer offset = 0; // Integer | 
        try {
            ApiResponse<List<SubAccountDetails>> response = apiInstance.listSubaccountsWithHttpInfo(xApiKey, limit, offset);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#listSubaccounts");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **xApiKey** | **String**|  | |
| **limit** | **Integer**|  | [optional] [default to 1000] |
| **offset** | **Integer**|  | [optional] [default to 0] |

### Return type

ApiResponse<[**List&lt;SubAccountDetails&gt;**](SubAccountDetails.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved all sub-accounts associated with the parent account. |  -  |
| **400** | Bad Request. The limit and/or offset query parameter are invalid. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## setSubaccountLimit

> LimitUpdateResult setSubaccountLimit(handle, xApiKey, limitInput)

Set Sub-account Limit

Sets the limit for the specified sub-account. The minimum allowed sends is 0. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to set limit for.
        String xApiKey = "xApiKey_example"; // String | 
        LimitInput limitInput = new LimitInput(); // LimitInput | The value the sub-account limit to set.
        try {
            LimitUpdateResult result = apiInstance.setSubaccountLimit(handle, xApiKey, limitInput);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#setSubaccountLimit");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to set limit for. | |
| **xApiKey** | **String**|  | |
| **limitInput** | [**LimitInput**](LimitInput.md)| The value the sub-account limit to set. | |

### Return type

[**LimitUpdateResult**](LimitUpdateResult.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The limit was successfully updated for the specified sub-account. |  -  |
| **400** | Missing or invalid limit value.  |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## setSubaccountLimitWithHttpInfo

> ApiResponse<LimitUpdateResult> setSubaccountLimitWithHttpInfo(handle, xApiKey, limitInput)

Set Sub-account Limit

Sets the limit for the specified sub-account. The minimum allowed sends is 0. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of the sub-account to set limit for.
        String xApiKey = "xApiKey_example"; // String | 
        LimitInput limitInput = new LimitInput(); // LimitInput | The value the sub-account limit to set.
        try {
            ApiResponse<LimitUpdateResult> response = apiInstance.setSubaccountLimitWithHttpInfo(handle, xApiKey, limitInput);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#setSubaccountLimit");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of the sub-account to set limit for. | |
| **xApiKey** | **String**|  | |
| **limitInput** | [**LimitInput**](LimitInput.md)| The value the sub-account limit to set. | |

### Return type

ApiResponse<[**LimitUpdateResult**](LimitUpdateResult.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The limit was successfully updated for the specified sub-account. |  -  |
| **400** | Missing or invalid limit value.  |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |


## suspendSubaccount

> void suspendSubaccount(handle, xApiKey)

Suspend Sub-account

Suspends the sub-account identified by its handle. This action disables the account, preventing it from sending any emails until it is reactivated. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of sub-account to be suspended.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.suspendSubaccount(handle, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#suspendSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of sub-account to be suspended. | |
| **xApiKey** | **String**|  | |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified sub-account is successfully suspended. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## suspendSubaccountWithHttpInfo

> ApiResponse<Void> suspendSubaccountWithHttpInfo(handle, xApiKey)

Suspend Sub-account

Suspends the sub-account identified by its handle. This action disables the account, preventing it from sending any emails until it is reactivated. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SubAccountsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SubAccountsApi apiInstance = new SubAccountsApi(defaultClient);
        String handle = "handle_example"; // String | Handle of sub-account to be suspended.
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.suspendSubaccountWithHttpInfo(handle, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SubAccountsApi#suspendSubaccount");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **handle** | **String**| Handle of sub-account to be suspended. | |
| **xApiKey** | **String**|  | |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified sub-account is successfully suspended. |  -  |
| **404** | The specified sub-account does not exist. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

