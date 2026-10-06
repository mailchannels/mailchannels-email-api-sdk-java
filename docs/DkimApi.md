# DkimApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**checkDomain**](DkimApi.md#checkDomain) | **POST** /check-domain | DKIM, SPF &amp; Domain Lockdown Check |
| [**checkDomainWithHttpInfo**](DkimApi.md#checkDomainWithHttpInfo) | **POST** /check-domain | DKIM, SPF &amp; Domain Lockdown Check |
| [**createDkimKey**](DkimApi.md#createDkimKey) | **POST** /domains/{domain}/dkim-keys | Create DKIM Key Pair |
| [**createDkimKeyWithHttpInfo**](DkimApi.md#createDkimKeyWithHttpInfo) | **POST** /domains/{domain}/dkim-keys | Create DKIM Key Pair |
| [**listDkimKeys**](DkimApi.md#listDkimKeys) | **GET** /domains/{domain}/dkim-keys | Retrieve DKIM Keys |
| [**listDkimKeysWithHttpInfo**](DkimApi.md#listDkimKeysWithHttpInfo) | **GET** /domains/{domain}/dkim-keys | Retrieve DKIM Keys |
| [**rotateDkimKey**](DkimApi.md#rotateDkimKey) | **POST** /domains/{domain}/dkim-keys/{selector}/rotate | Rotate DKIM Key Pair |
| [**rotateDkimKeyWithHttpInfo**](DkimApi.md#rotateDkimKeyWithHttpInfo) | **POST** /domains/{domain}/dkim-keys/{selector}/rotate | Rotate DKIM Key Pair |
| [**updateDkimKey**](DkimApi.md#updateDkimKey) | **PATCH** /domains/{domain}/dkim-keys/{selector} | Update DKIM Key Status |
| [**updateDkimKeyWithHttpInfo**](DkimApi.md#updateDkimKeyWithHttpInfo) | **PATCH** /domains/{domain}/dkim-keys/{selector} | Update DKIM Key Status |



## checkDomain

> CheckDomainResult checkDomain(xApiKey, checkDomainBody)

DKIM, SPF &amp; Domain Lockdown Check

Validates a domain&#39;s email authentication setup by retrieving its DKIM, SPF, and Domain Lockdown status. This endpoint checks whether the domain is properly configured for secure email delivery. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        CheckDomainBody checkDomainBody = new CheckDomainBody(); // CheckDomainBody | 
        try {
            CheckDomainResult result = apiInstance.checkDomain(xApiKey, checkDomainBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#checkDomain");
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
| **checkDomainBody** | [**CheckDomainBody**](CheckDomainBody.md)|  | |

### Return type

[**CheckDomainResult**](CheckDomainResult.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. |  -  |
| **400** | Bad Request |  -  |
| **403** | User does not have access to this feature |  -  |

## checkDomainWithHttpInfo

> ApiResponse<CheckDomainResult> checkDomainWithHttpInfo(xApiKey, checkDomainBody)

DKIM, SPF &amp; Domain Lockdown Check

Validates a domain&#39;s email authentication setup by retrieving its DKIM, SPF, and Domain Lockdown status. This endpoint checks whether the domain is properly configured for secure email delivery. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        CheckDomainBody checkDomainBody = new CheckDomainBody(); // CheckDomainBody | 
        try {
            ApiResponse<CheckDomainResult> response = apiInstance.checkDomainWithHttpInfo(xApiKey, checkDomainBody);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#checkDomain");
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
| **checkDomainBody** | [**CheckDomainBody**](CheckDomainBody.md)|  | |

### Return type

ApiResponse<[**CheckDomainResult**](CheckDomainResult.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. |  -  |
| **400** | Bad Request |  -  |
| **403** | User does not have access to this feature |  -  |


## createDkimKey

> DKIMKeyInfo createDkimKey(domain, xApiKey, dkIMKeyPairCreateRequest)

Create DKIM Key Pair

Create a DKIM key pair for a specified domain and selector using the specified algorithm and key length, for the current customer. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        DKIMKeyPairCreateRequest dkIMKeyPairCreateRequest = new DKIMKeyPairCreateRequest(); // DKIMKeyPairCreateRequest | 
        try {
            DKIMKeyInfo result = apiInstance.createDkimKey(domain, xApiKey, dkIMKeyPairCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#createDkimKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **xApiKey** | **String**|  | |
| **dkIMKeyPairCreateRequest** | [**DKIMKeyPairCreateRequest**](DKIMKeyPairCreateRequest.md)|  | |

### Return type

[**DKIMKeyInfo**](DKIMKeyInfo.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Key pair created successfully |  -  |
| **400** | Bad Request |  -  |
| **409** | Key pair already created for domain, and selector  |  -  |
| **500** | Internal Server Error |  -  |

## createDkimKeyWithHttpInfo

> ApiResponse<DKIMKeyInfo> createDkimKeyWithHttpInfo(domain, xApiKey, dkIMKeyPairCreateRequest)

Create DKIM Key Pair

Create a DKIM key pair for a specified domain and selector using the specified algorithm and key length, for the current customer. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        DKIMKeyPairCreateRequest dkIMKeyPairCreateRequest = new DKIMKeyPairCreateRequest(); // DKIMKeyPairCreateRequest | 
        try {
            ApiResponse<DKIMKeyInfo> response = apiInstance.createDkimKeyWithHttpInfo(domain, xApiKey, dkIMKeyPairCreateRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#createDkimKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **xApiKey** | **String**|  | |
| **dkIMKeyPairCreateRequest** | [**DKIMKeyPairCreateRequest**](DKIMKeyPairCreateRequest.md)|  | |

### Return type

ApiResponse<[**DKIMKeyInfo**](DKIMKeyInfo.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Key pair created successfully |  -  |
| **400** | Bad Request |  -  |
| **409** | Key pair already created for domain, and selector  |  -  |
| **500** | Internal Server Error |  -  |


## listDkimKeys

> DKIMKeyList listDkimKeys(domain, xApiKey, selector, status, offset, limit, includeDnsRecord)

Retrieve DKIM Keys

Search for DKIM keys by domain, with optional filters. If selector is provided, at most one key will be returned. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        String selector = "selector_example"; // String | 
        String status = "active"; // String | 
        Integer offset = 0; // Integer | Number of keys to skip before returning results. The default is 0. 
        Integer limit = 10; // Integer | Maximum number of keys to return. The default is 10. 
        Boolean includeDnsRecord = false; // Boolean | If true, includes the suggested DKIM DNS record for each returned key. Defaults to false. 
        try {
            DKIMKeyList result = apiInstance.listDkimKeys(domain, xApiKey, selector, status, offset, limit, includeDnsRecord);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#listDkimKeys");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **xApiKey** | **String**|  | |
| **selector** | **String**|  | [optional] |
| **status** | **String**|  | [optional] [enum: active, retired, revoked, rotated] |
| **offset** | **Integer**| Number of keys to skip before returning results. The default is 0.  | [optional] [default to 0] |
| **limit** | **Integer**| Maximum number of keys to return. The default is 10.  | [optional] [default to 10] |
| **includeDnsRecord** | **Boolean**| If true, includes the suggested DKIM DNS record for each returned key. Defaults to false.  | [optional] [default to false] |

### Return type

[**DKIMKeyList**](DKIMKeyList.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved DKIM keys |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

## listDkimKeysWithHttpInfo

> ApiResponse<DKIMKeyList> listDkimKeysWithHttpInfo(domain, xApiKey, selector, status, offset, limit, includeDnsRecord)

Retrieve DKIM Keys

Search for DKIM keys by domain, with optional filters. If selector is provided, at most one key will be returned. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        String selector = "selector_example"; // String | 
        String status = "active"; // String | 
        Integer offset = 0; // Integer | Number of keys to skip before returning results. The default is 0. 
        Integer limit = 10; // Integer | Maximum number of keys to return. The default is 10. 
        Boolean includeDnsRecord = false; // Boolean | If true, includes the suggested DKIM DNS record for each returned key. Defaults to false. 
        try {
            ApiResponse<DKIMKeyList> response = apiInstance.listDkimKeysWithHttpInfo(domain, xApiKey, selector, status, offset, limit, includeDnsRecord);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#listDkimKeys");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **xApiKey** | **String**|  | |
| **selector** | **String**|  | [optional] |
| **status** | **String**|  | [optional] [enum: active, retired, revoked, rotated] |
| **offset** | **Integer**| Number of keys to skip before returning results. The default is 0.  | [optional] [default to 0] |
| **limit** | **Integer**| Maximum number of keys to return. The default is 10.  | [optional] [default to 10] |
| **includeDnsRecord** | **Boolean**| If true, includes the suggested DKIM DNS record for each returned key. Defaults to false.  | [optional] [default to false] |

### Return type

ApiResponse<[**DKIMKeyList**](DKIMKeyList.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved DKIM keys |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |


## rotateDkimKey

> DKIMKeyRotateResponse rotateDkimKey(domain, selector, xApiKey, dkIMKeyRotateRequest)

Rotate DKIM Key Pair

Rotate an active DKIM key pair. Mark the original key as &#39;rotated&#39;, and create a new key pair with the required new key selector, reusing the same algorithm and key length. The rotated key remains valid for signing for a 3-day grace period, and is automatically changed to &#39;retired&#39; 2 weeks after rotation. Publish the new key to its DNS TXT record before rotated key expires for signing as emails sent with an unpublished key will fail DKIM validation by receiving providers. After the grace period, only the new key is valid for signing if published.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String selector = "selector_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        DKIMKeyRotateRequest dkIMKeyRotateRequest = new DKIMKeyRotateRequest(); // DKIMKeyRotateRequest | 
        try {
            DKIMKeyRotateResponse result = apiInstance.rotateDkimKey(domain, selector, xApiKey, dkIMKeyRotateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#rotateDkimKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **selector** | **String**|  | |
| **xApiKey** | **String**|  | |
| **dkIMKeyRotateRequest** | [**DKIMKeyRotateRequest**](DKIMKeyRotateRequest.md)|  | |

### Return type

[**DKIMKeyRotateResponse**](DKIMKeyRotateResponse.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Key pair status updated and new key pair created successfully |  -  |
| **400** | Bad Request |  -  |
| **404** | Specified key pair not found |  -  |
| **409** | Key pair already created for domain, and provided new key selector.  |  -  |
| **500** | Internal Server Error |  -  |
| **503** | Temporarily unavailable for maintenance |  * Retry-After - Suggested wait time in seconds before retrying.  <br>  |

## rotateDkimKeyWithHttpInfo

> ApiResponse<DKIMKeyRotateResponse> rotateDkimKeyWithHttpInfo(domain, selector, xApiKey, dkIMKeyRotateRequest)

Rotate DKIM Key Pair

Rotate an active DKIM key pair. Mark the original key as &#39;rotated&#39;, and create a new key pair with the required new key selector, reusing the same algorithm and key length. The rotated key remains valid for signing for a 3-day grace period, and is automatically changed to &#39;retired&#39; 2 weeks after rotation. Publish the new key to its DNS TXT record before rotated key expires for signing as emails sent with an unpublished key will fail DKIM validation by receiving providers. After the grace period, only the new key is valid for signing if published.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String selector = "selector_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        DKIMKeyRotateRequest dkIMKeyRotateRequest = new DKIMKeyRotateRequest(); // DKIMKeyRotateRequest | 
        try {
            ApiResponse<DKIMKeyRotateResponse> response = apiInstance.rotateDkimKeyWithHttpInfo(domain, selector, xApiKey, dkIMKeyRotateRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#rotateDkimKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **selector** | **String**|  | |
| **xApiKey** | **String**|  | |
| **dkIMKeyRotateRequest** | [**DKIMKeyRotateRequest**](DKIMKeyRotateRequest.md)|  | |

### Return type

ApiResponse<[**DKIMKeyRotateResponse**](DKIMKeyRotateResponse.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Key pair status updated and new key pair created successfully |  -  |
| **400** | Bad Request |  -  |
| **404** | Specified key pair not found |  -  |
| **409** | Key pair already created for domain, and provided new key selector.  |  -  |
| **500** | Internal Server Error |  -  |
| **503** | Temporarily unavailable for maintenance |  * Retry-After - Suggested wait time in seconds before retrying.  <br>  |


## updateDkimKey

> void updateDkimKey(domain, selector, xApiKey, dkIMKeyPairUpdateRequest)

Update DKIM Key Status

Update fields of an existing DKIM key pair for the specified domain and selector, for the current customer. Currently, only the status field can be updated. revoked: Indicates that the key is compromised and should not be used. retired: Indicates that the key has been rotated and is no longer in use. rotated: Indicates that the key is going through the rotation process. Only active key pairs can be updated to this status, and no new key pair is created. The rotated key can be used to sign emails for 3 days after the status update, and will automatically change to &#39;retired&#39; 2 weeks after update. For a smooth key transition, it is recommended to create and publish a new key pair before signing is disabled for the rotated key. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String selector = "selector_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        DKIMKeyPairUpdateRequest dkIMKeyPairUpdateRequest = new DKIMKeyPairUpdateRequest(); // DKIMKeyPairUpdateRequest | 
        try {
            apiInstance.updateDkimKey(domain, selector, xApiKey, dkIMKeyPairUpdateRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#updateDkimKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **selector** | **String**|  | |
| **xApiKey** | **String**|  | |
| **dkIMKeyPairUpdateRequest** | [**DKIMKeyPairUpdateRequest**](DKIMKeyPairUpdateRequest.md)|  | |

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
| **204** | Key pair status updated successfully |  -  |
| **400** | Status not supported |  -  |
| **404** | Specified key pair not found, or no active key for rotation This may also occur if the DKIM domain or selector path parameter is missing.  |  -  |
| **500** | Internal Server Error |  -  |

## updateDkimKeyWithHttpInfo

> ApiResponse<Void> updateDkimKeyWithHttpInfo(domain, selector, xApiKey, dkIMKeyPairUpdateRequest)

Update DKIM Key Status

Update fields of an existing DKIM key pair for the specified domain and selector, for the current customer. Currently, only the status field can be updated. revoked: Indicates that the key is compromised and should not be used. retired: Indicates that the key has been rotated and is no longer in use. rotated: Indicates that the key is going through the rotation process. Only active key pairs can be updated to this status, and no new key pair is created. The rotated key can be used to sign emails for 3 days after the status update, and will automatically change to &#39;retired&#39; 2 weeks after update. For a smooth key transition, it is recommended to create and publish a new key pair before signing is disabled for the rotated key. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.DkimApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        DkimApi apiInstance = new DkimApi(defaultClient);
        String domain = "domain_example"; // String | 
        String selector = "selector_example"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        DKIMKeyPairUpdateRequest dkIMKeyPairUpdateRequest = new DKIMKeyPairUpdateRequest(); // DKIMKeyPairUpdateRequest | 
        try {
            ApiResponse<Void> response = apiInstance.updateDkimKeyWithHttpInfo(domain, selector, xApiKey, dkIMKeyPairUpdateRequest);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling DkimApi#updateDkimKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **domain** | **String**|  | |
| **selector** | **String**|  | |
| **xApiKey** | **String**|  | |
| **dkIMKeyPairUpdateRequest** | [**DKIMKeyPairUpdateRequest**](DKIMKeyPairUpdateRequest.md)|  | |

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
| **204** | Key pair status updated successfully |  -  |
| **400** | Status not supported |  -  |
| **404** | Specified key pair not found, or no active key for rotation This may also occur if the DKIM domain or selector path parameter is missing.  |  -  |
| **500** | Internal Server Error |  -  |

