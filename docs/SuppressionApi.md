# SuppressionApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSuppressions**](SuppressionApi.md#createSuppressions) | **POST** /suppression-list | Create Suppression Entries |
| [**createSuppressionsWithHttpInfo**](SuppressionApi.md#createSuppressionsWithHttpInfo) | **POST** /suppression-list | Create Suppression Entries |
| [**deleteSuppression**](SuppressionApi.md#deleteSuppression) | **DELETE** /suppression-list/recipients/{recipient} | Delete Suppression Entry |
| [**deleteSuppressionWithHttpInfo**](SuppressionApi.md#deleteSuppressionWithHttpInfo) | **DELETE** /suppression-list/recipients/{recipient} | Delete Suppression Entry |
| [**listSuppressions**](SuppressionApi.md#listSuppressions) | **GET** /suppression-list | Retrieve Suppression List |
| [**listSuppressionsWithHttpInfo**](SuppressionApi.md#listSuppressionsWithHttpInfo) | **GET** /suppression-list | Retrieve Suppression List |



## createSuppressions

> void createSuppressions(xApiKey, suppressionListInput)

Create Suppression Entries

Creates suppression entries for the specified account. Parent accounts can create suppression entries for all associated sub-accounts. If suppression_type is not provided, it defaults to &#39;non-transactional&#39;. The operation is atomic, meaning all entries are successfully added or none are added if an error occurs. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SuppressionApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SuppressionApi apiInstance = new SuppressionApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        SuppressionListInput suppressionListInput = new SuppressionListInput(); // SuppressionListInput | The details of the suppression entries to create.
        try {
            apiInstance.createSuppressions(xApiKey, suppressionListInput);
        } catch (ApiException e) {
            System.err.println("Exception when calling SuppressionApi#createSuppressions");
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
| **suppressionListInput** | [**SuppressionListInput**](SuppressionListInput.md)| The details of the suppression entries to create. | |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | All suppression entries were successfully created. |  -  |
| **400** | Bad request. The request body is invalid. |  -  |
| **409** | Conflicts. One or more suppression entries in the request already exist and cannot be created again.  |  -  |
| **413** | Payload too large. The request exceeds the maximum allowed total of 1000 suppression entries for the parent account and/or its sub-accounts.  |  -  |
| **500** | An unexpected internal error occurred. |  -  |
| **503** | Temporarily unavailable for maintenance. |  -  |

## createSuppressionsWithHttpInfo

> ApiResponse<Void> createSuppressionsWithHttpInfo(xApiKey, suppressionListInput)

Create Suppression Entries

Creates suppression entries for the specified account. Parent accounts can create suppression entries for all associated sub-accounts. If suppression_type is not provided, it defaults to &#39;non-transactional&#39;. The operation is atomic, meaning all entries are successfully added or none are added if an error occurs. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SuppressionApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SuppressionApi apiInstance = new SuppressionApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        SuppressionListInput suppressionListInput = new SuppressionListInput(); // SuppressionListInput | The details of the suppression entries to create.
        try {
            ApiResponse<Void> response = apiInstance.createSuppressionsWithHttpInfo(xApiKey, suppressionListInput);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SuppressionApi#createSuppressions");
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
| **suppressionListInput** | [**SuppressionListInput**](SuppressionListInput.md)| The details of the suppression entries to create. | |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | All suppression entries were successfully created. |  -  |
| **400** | Bad request. The request body is invalid. |  -  |
| **409** | Conflicts. One or more suppression entries in the request already exist and cannot be created again.  |  -  |
| **413** | Payload too large. The request exceeds the maximum allowed total of 1000 suppression entries for the parent account and/or its sub-accounts.  |  -  |
| **500** | An unexpected internal error occurred. |  -  |
| **503** | Temporarily unavailable for maintenance. |  -  |


## deleteSuppression

> void deleteSuppression(recipient, xApiKey, source)

Delete Suppression Entry

Deletes suppression entry associated with the account based on the specified recipient and source. If source is not provided, it defaults to &#39;api&#39;. If source is set to &#39;all&#39;, all suppression entries related to the specified recipient will be deleted. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SuppressionApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SuppressionApi apiInstance = new SuppressionApi(defaultClient);
        String recipient = "recipient_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        String source = "api"; // String | 
        try {
            apiInstance.deleteSuppression(recipient, xApiKey, source);
        } catch (ApiException e) {
            System.err.println("Exception when calling SuppressionApi#deleteSuppression");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **recipient** | **String**|  | |
| **xApiKey** | **String**|  | |
| **source** | **String**|  | [optional] [default to api] [enum: api, unsubscribe_link, list_unsubscribe, hard_bounce, spam_complaint, all] |

### Return type


null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified suppression entry was successfully deleted. |  -  |
| **400** | Bad request. The request is invalid. |  -  |
| **500** | An unexpected internal error occurred. |  -  |
| **503** | Temporarily unavailable for maintenance. |  -  |

## deleteSuppressionWithHttpInfo

> ApiResponse<Void> deleteSuppressionWithHttpInfo(recipient, xApiKey, source)

Delete Suppression Entry

Deletes suppression entry associated with the account based on the specified recipient and source. If source is not provided, it defaults to &#39;api&#39;. If source is set to &#39;all&#39;, all suppression entries related to the specified recipient will be deleted. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SuppressionApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SuppressionApi apiInstance = new SuppressionApi(defaultClient);
        String recipient = "recipient_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        String source = "api"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.deleteSuppressionWithHttpInfo(recipient, xApiKey, source);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling SuppressionApi#deleteSuppression");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **recipient** | **String**|  | |
| **xApiKey** | **String**|  | |
| **source** | **String**|  | [optional] [default to api] [enum: api, unsubscribe_link, list_unsubscribe, hard_bounce, spam_complaint, all] |

### Return type


ApiResponse<Void>

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | The specified suppression entry was successfully deleted. |  -  |
| **400** | Bad request. The request is invalid. |  -  |
| **500** | An unexpected internal error occurred. |  -  |
| **503** | Temporarily unavailable for maintenance. |  -  |


## listSuppressions

> SuppressionListResponse listSuppressions(xApiKey, recipient, source, createdBefore, createdAfter, limit, offset)

Retrieve Suppression List

Retrieve suppression entries associated with the specified account. Supports filtering by recipient, source and creation date range. The response is paginated, with a default limit of 1000 entries per page and an offset of 0. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SuppressionApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SuppressionApi apiInstance = new SuppressionApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String recipient = "recipient_example"; // String | 
        String source = "api"; // String | 
        String createdBefore = "createdBefore_example"; // String | The date and/or time before which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        String createdAfter = "createdAfter_example"; // String | The date and/or time after which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        Integer limit = 1000; // Integer | The maximum number of suppression entries to return. The default is 1000. 
        Integer offset = 0; // Integer | The number of suppression entries to skip before returning results. The default is 0. 
        try {
            SuppressionListResponse result = apiInstance.listSuppressions(xApiKey, recipient, source, createdBefore, createdAfter, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SuppressionApi#listSuppressions");
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
| **recipient** | **String**|  | [optional] |
| **source** | **String**|  | [optional] [enum: api, unsubscribe_link, list_unsubscribe, hard_bounce, spam_complaint] |
| **createdBefore** | **String**| The date and/or time before which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **createdAfter** | **String**| The date and/or time after which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **limit** | **Integer**| The maximum number of suppression entries to return. The default is 1000.  | [optional] [default to 1000] |
| **offset** | **Integer**| The number of suppression entries to skip before returning results. The default is 0.  | [optional] [default to 0] |

### Return type

[**SuppressionListResponse**](SuppressionListResponse.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved all suppression entries associated with the account. |  -  |
| **400** | Bad request. The request is invalid. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

## listSuppressionsWithHttpInfo

> ApiResponse<SuppressionListResponse> listSuppressionsWithHttpInfo(xApiKey, recipient, source, createdBefore, createdAfter, limit, offset)

Retrieve Suppression List

Retrieve suppression entries associated with the specified account. Supports filtering by recipient, source and creation date range. The response is paginated, with a default limit of 1000 entries per page and an offset of 0. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SuppressionApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SuppressionApi apiInstance = new SuppressionApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String recipient = "recipient_example"; // String | 
        String source = "api"; // String | 
        String createdBefore = "createdBefore_example"; // String | The date and/or time before which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        String createdAfter = "createdAfter_example"; // String | The date and/or time after which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        Integer limit = 1000; // Integer | The maximum number of suppression entries to return. The default is 1000. 
        Integer offset = 0; // Integer | The number of suppression entries to skip before returning results. The default is 0. 
        try {
            ApiResponse<SuppressionListResponse> response = apiInstance.listSuppressionsWithHttpInfo(xApiKey, recipient, source, createdBefore, createdAfter, limit, offset);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SuppressionApi#listSuppressions");
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
| **recipient** | **String**|  | [optional] |
| **source** | **String**|  | [optional] [enum: api, unsubscribe_link, list_unsubscribe, hard_bounce, spam_complaint] |
| **createdBefore** | **String**| The date and/or time before which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **createdAfter** | **String**| The date and/or time after which the suppression entries were created. Format: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **limit** | **Integer**| The maximum number of suppression entries to return. The default is 1000.  | [optional] [default to 1000] |
| **offset** | **Integer**| The number of suppression entries to skip before returning results. The default is 0.  | [optional] [default to 0] |

### Return type

ApiResponse<[**SuppressionListResponse**](SuppressionListResponse.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved all suppression entries associated with the account. |  -  |
| **400** | Bad request. The request is invalid. |  -  |
| **500** | An unexpected internal error occurred. |  -  |

