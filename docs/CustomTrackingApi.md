# CustomTrackingApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCustomTrackingDomain**](CustomTrackingApi.md#createCustomTrackingDomain) | **POST** /custom-tracking-domains | Register Custom Tracking Domain |
| [**createCustomTrackingDomainWithHttpInfo**](CustomTrackingApi.md#createCustomTrackingDomainWithHttpInfo) | **POST** /custom-tracking-domains | Register Custom Tracking Domain |
| [**deleteCustomTrackingDomain**](CustomTrackingApi.md#deleteCustomTrackingDomain) | **DELETE** /custom-tracking-domains/{hostname}/{scope} | Delete Custom Tracking Domain |
| [**deleteCustomTrackingDomainWithHttpInfo**](CustomTrackingApi.md#deleteCustomTrackingDomainWithHttpInfo) | **DELETE** /custom-tracking-domains/{hostname}/{scope} | Delete Custom Tracking Domain |
| [**listCustomTrackingDomains**](CustomTrackingApi.md#listCustomTrackingDomains) | **GET** /custom-tracking-domains | Retrieve Custom Tracking Domains |
| [**listCustomTrackingDomainsWithHttpInfo**](CustomTrackingApi.md#listCustomTrackingDomainsWithHttpInfo) | **GET** /custom-tracking-domains | Retrieve Custom Tracking Domains |
| [**updateCustomTrackingDomain**](CustomTrackingApi.md#updateCustomTrackingDomain) | **PATCH** /custom-tracking-domains/{hostname}/{scope} | Update Custom Tracking Domain |
| [**updateCustomTrackingDomainWithHttpInfo**](CustomTrackingApi.md#updateCustomTrackingDomainWithHttpInfo) | **PATCH** /custom-tracking-domains/{hostname}/{scope} | Update Custom Tracking Domain |



## createCustomTrackingDomain

> CreateTrackingResult createCustomTrackingDomain(xApiKey, postCustomTrackingDomainRequest)

Register Custom Tracking Domain

Register a custom branded domain for click tracking, open tracking, or unsubscribe handling. By default, MailChannels uses shared domains for these links. Using a custom domain improves brand consistency by replacing shared domains with your own (e.g., click.example.com). Once registered, select the domain at send time using its &#x60;name&#x60;.  Before registration completes, two DNS records must be in place: 1. A TXT record at &#x60;_mailchannels-verify.&lt;hostname&gt;&#x60; containing the verification token    (returned in the 202 response). 2. A CNAME record at &#x60;&lt;hostname&gt;&#x60; pointing to &#x60;links.mailchannels.net&#x60;. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        PostCustomTrackingDomainRequest postCustomTrackingDomainRequest = new PostCustomTrackingDomainRequest(); // PostCustomTrackingDomainRequest | 
        try {
            CreateTrackingResult result = apiInstance.createCustomTrackingDomain(xApiKey, postCustomTrackingDomainRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#createCustomTrackingDomain");
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
| **postCustomTrackingDomainRequest** | [**PostCustomTrackingDomainRequest**](PostCustomTrackingDomainRequest.md)|  | |

### Return type

[**CreateTrackingResult**](CreateTrackingResult.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Domain verified and registered |  -  |
| **202** | Verification required — add the DNS TXT record and CNAME record described in the response body, then retry |  -  |
| **400** | Invalid request body |  -  |
| **403** | No permission to register this domain |  -  |
| **409** | A domain with the same name already exists, or the hostname and scope combination is already registered |  -  |
| **422** | DNS verification incomplete. Either the TXT ownership record has not propagated yet or the hostname CNAME does not point to the required target. Check the &#x60;instructions&#x60; field and retry once both records are in place.  |  -  |
| **500** | Internal Server Error |  -  |

## createCustomTrackingDomainWithHttpInfo

> ApiResponse<CreateTrackingResult> createCustomTrackingDomainWithHttpInfo(xApiKey, postCustomTrackingDomainRequest)

Register Custom Tracking Domain

Register a custom branded domain for click tracking, open tracking, or unsubscribe handling. By default, MailChannels uses shared domains for these links. Using a custom domain improves brand consistency by replacing shared domains with your own (e.g., click.example.com). Once registered, select the domain at send time using its &#x60;name&#x60;.  Before registration completes, two DNS records must be in place: 1. A TXT record at &#x60;_mailchannels-verify.&lt;hostname&gt;&#x60; containing the verification token    (returned in the 202 response). 2. A CNAME record at &#x60;&lt;hostname&gt;&#x60; pointing to &#x60;links.mailchannels.net&#x60;. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        PostCustomTrackingDomainRequest postCustomTrackingDomainRequest = new PostCustomTrackingDomainRequest(); // PostCustomTrackingDomainRequest | 
        try {
            ApiResponse<CreateTrackingResult> response = apiInstance.createCustomTrackingDomainWithHttpInfo(xApiKey, postCustomTrackingDomainRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#createCustomTrackingDomain");
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
| **postCustomTrackingDomainRequest** | [**PostCustomTrackingDomainRequest**](PostCustomTrackingDomainRequest.md)|  | |

### Return type

ApiResponse<[**CreateTrackingResult**](CreateTrackingResult.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Domain verified and registered |  -  |
| **202** | Verification required — add the DNS TXT record and CNAME record described in the response body, then retry |  -  |
| **400** | Invalid request body |  -  |
| **403** | No permission to register this domain |  -  |
| **409** | A domain with the same name already exists, or the hostname and scope combination is already registered |  -  |
| **422** | DNS verification incomplete. Either the TXT ownership record has not propagated yet or the hostname CNAME does not point to the required target. Check the &#x60;instructions&#x60; field and retry once both records are in place.  |  -  |
| **500** | Internal Server Error |  -  |


## deleteCustomTrackingDomain

> void deleteCustomTrackingDomain(hostname, scope, xApiKey)

Delete Custom Tracking Domain

Permanently delete an existing custom tracking domain for the given hostname and scope. The domain can be re-registered if needed. WARNING: Any tracking links or unsubscribe URLs in previously sent emails using this domain will stop working immediately. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String hostname = "hostname_example"; // String | 
        String scope = "click"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.deleteCustomTrackingDomain(hostname, scope, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#deleteCustomTrackingDomain");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **hostname** | **String**|  | |
| **scope** | **String**|  | [enum: click, open, unsubscribe] |
| **xApiKey** | **String**|  | |

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
| **204** | Custom tracking domain successfully deleted |  -  |
| **400** | Invalid hostname or scope value |  -  |
| **500** | Internal server error |  -  |

## deleteCustomTrackingDomainWithHttpInfo

> ApiResponse<Void> deleteCustomTrackingDomainWithHttpInfo(hostname, scope, xApiKey)

Delete Custom Tracking Domain

Permanently delete an existing custom tracking domain for the given hostname and scope. The domain can be re-registered if needed. WARNING: Any tracking links or unsubscribe URLs in previously sent emails using this domain will stop working immediately. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String hostname = "hostname_example"; // String | 
        String scope = "click"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.deleteCustomTrackingDomainWithHttpInfo(hostname, scope, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#deleteCustomTrackingDomain");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **hostname** | **String**|  | |
| **scope** | **String**|  | [enum: click, open, unsubscribe] |
| **xApiKey** | **String**|  | |

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
| **204** | Custom tracking domain successfully deleted |  -  |
| **400** | Invalid hostname or scope value |  -  |
| **500** | Internal server error |  -  |


## listCustomTrackingDomains

> CustomTrackingDomainListResponse listCustomTrackingDomains(xApiKey, name, status, scope, limit, offset)

Retrieve Custom Tracking Domains

Retrieve all custom tracking domains registered under your account. Optional filters include domain name, status, scope, limit and offset. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String name = "name_example"; // String | Filter by custom tracking domain label
        String status = "active"; // String | Filter by status
        String scope = "click"; // String | Filter by scope
        Integer limit = 100; // Integer | The maximum number of domains to return. The default is 100.
        Integer offset = 0; // Integer | The number of domains to skip before returning results. The default is 0.
        try {
            CustomTrackingDomainListResponse result = apiInstance.listCustomTrackingDomains(xApiKey, name, status, scope, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#listCustomTrackingDomains");
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
| **name** | **String**| Filter by custom tracking domain label | [optional] |
| **status** | **String**| Filter by status | [optional] [enum: active, disabled] |
| **scope** | **String**| Filter by scope | [optional] [enum: click, open, unsubscribe] |
| **limit** | **Integer**| The maximum number of domains to return. The default is 100. | [optional] [default to 100] |
| **offset** | **Integer**| The number of domains to skip before returning results. The default is 0. | [optional] [default to 0] |

### Return type

[**CustomTrackingDomainListResponse**](CustomTrackingDomainListResponse.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response with the list of custom tracking domains |  -  |
| **400** | Invalid query parameter value |  -  |
| **500** | Internal server error |  -  |

## listCustomTrackingDomainsWithHttpInfo

> ApiResponse<CustomTrackingDomainListResponse> listCustomTrackingDomainsWithHttpInfo(xApiKey, name, status, scope, limit, offset)

Retrieve Custom Tracking Domains

Retrieve all custom tracking domains registered under your account. Optional filters include domain name, status, scope, limit and offset. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String name = "name_example"; // String | Filter by custom tracking domain label
        String status = "active"; // String | Filter by status
        String scope = "click"; // String | Filter by scope
        Integer limit = 100; // Integer | The maximum number of domains to return. The default is 100.
        Integer offset = 0; // Integer | The number of domains to skip before returning results. The default is 0.
        try {
            ApiResponse<CustomTrackingDomainListResponse> response = apiInstance.listCustomTrackingDomainsWithHttpInfo(xApiKey, name, status, scope, limit, offset);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#listCustomTrackingDomains");
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
| **name** | **String**| Filter by custom tracking domain label | [optional] |
| **status** | **String**| Filter by status | [optional] [enum: active, disabled] |
| **scope** | **String**| Filter by scope | [optional] [enum: click, open, unsubscribe] |
| **limit** | **Integer**| The maximum number of domains to return. The default is 100. | [optional] [default to 100] |
| **offset** | **Integer**| The number of domains to skip before returning results. The default is 0. | [optional] [default to 0] |

### Return type

ApiResponse<[**CustomTrackingDomainListResponse**](CustomTrackingDomainListResponse.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Response with the list of custom tracking domains |  -  |
| **400** | Invalid query parameter value |  -  |
| **500** | Internal server error |  -  |


## updateCustomTrackingDomain

> UpdateTrackingResult updateCustomTrackingDomain(hostname, scope, xApiKey, patchCustomTrackingDomainRequest)

Update Custom Tracking Domain

Update an existing custom tracking domain by its hostname and scope. Supports updating the custom tracking domain&#39;s name or toggling its active status. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String hostname = "hostname_example"; // String | 
        String scope = "click"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        PatchCustomTrackingDomainRequest patchCustomTrackingDomainRequest = new PatchCustomTrackingDomainRequest(); // PatchCustomTrackingDomainRequest | 
        try {
            UpdateTrackingResult result = apiInstance.updateCustomTrackingDomain(hostname, scope, xApiKey, patchCustomTrackingDomainRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#updateCustomTrackingDomain");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **hostname** | **String**|  | |
| **scope** | **String**|  | [enum: click, open, unsubscribe] |
| **xApiKey** | **String**|  | |
| **patchCustomTrackingDomainRequest** | [**PatchCustomTrackingDomainRequest**](PatchCustomTrackingDomainRequest.md)|  | |

### Return type

[**UpdateTrackingResult**](UpdateTrackingResult.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Custom tracking domain updated |  -  |
| **202** | Re-activation requires DNS verification — add the TXT record and CNAME record described in the response body, then retry |  -  |
| **400** | Invalid request body |  -  |
| **403** | No permission to activate this domain |  -  |
| **404** | Domain not found |  -  |
| **409** | Name already used by another domain |  -  |
| **422** | DNS verification incomplete. Either the TXT ownership record has not propagated yet or the hostname CNAME does not point to the required target. Check the &#x60;instructions&#x60; field and retry once both records are in place.  |  -  |
| **500** | Internal server error |  -  |

## updateCustomTrackingDomainWithHttpInfo

> ApiResponse<UpdateTrackingResult> updateCustomTrackingDomainWithHttpInfo(hostname, scope, xApiKey, patchCustomTrackingDomainRequest)

Update Custom Tracking Domain

Update an existing custom tracking domain by its hostname and scope. Supports updating the custom tracking domain&#39;s name or toggling its active status. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.CustomTrackingApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        CustomTrackingApi apiInstance = new CustomTrackingApi(defaultClient);
        String hostname = "hostname_example"; // String | 
        String scope = "click"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        PatchCustomTrackingDomainRequest patchCustomTrackingDomainRequest = new PatchCustomTrackingDomainRequest(); // PatchCustomTrackingDomainRequest | 
        try {
            ApiResponse<UpdateTrackingResult> response = apiInstance.updateCustomTrackingDomainWithHttpInfo(hostname, scope, xApiKey, patchCustomTrackingDomainRequest);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomTrackingApi#updateCustomTrackingDomain");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **hostname** | **String**|  | |
| **scope** | **String**|  | [enum: click, open, unsubscribe] |
| **xApiKey** | **String**|  | |
| **patchCustomTrackingDomainRequest** | [**PatchCustomTrackingDomainRequest**](PatchCustomTrackingDomainRequest.md)|  | |

### Return type

ApiResponse<[**UpdateTrackingResult**](UpdateTrackingResult.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Custom tracking domain updated |  -  |
| **202** | Re-activation requires DNS verification — add the TXT record and CNAME record described in the response body, then retry |  -  |
| **400** | Invalid request body |  -  |
| **403** | No permission to activate this domain |  -  |
| **404** | Domain not found |  -  |
| **409** | Name already used by another domain |  -  |
| **422** | DNS verification incomplete. Either the TXT ownership record has not propagated yet or the hostname CNAME does not point to the required target. Check the &#x60;instructions&#x60; field and retry once both records are in place.  |  -  |
| **500** | Internal server error |  -  |

