# WebhooksApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createWebhook**](WebhooksApi.md#createWebhook) | **POST** /webhook | Enroll for Webhook Notifications |
| [**createWebhookWithHttpInfo**](WebhooksApi.md#createWebhookWithHttpInfo) | **POST** /webhook | Enroll for Webhook Notifications |
| [**deleteWebhooks**](WebhooksApi.md#deleteWebhooks) | **DELETE** /webhook | Delete Customer Webhooks |
| [**deleteWebhooksWithHttpInfo**](WebhooksApi.md#deleteWebhooksWithHttpInfo) | **DELETE** /webhook | Delete Customer Webhooks |
| [**getWebhookSigningKey**](WebhooksApi.md#getWebhookSigningKey) | **GET** /webhook/public-key | Retrieve Webhook Signing Key |
| [**getWebhookSigningKeyWithHttpInfo**](WebhooksApi.md#getWebhookSigningKeyWithHttpInfo) | **GET** /webhook/public-key | Retrieve Webhook Signing Key |
| [**listWebhookBatches**](WebhooksApi.md#listWebhookBatches) | **GET** /webhook-batch | Retrieve Webhook Batches |
| [**listWebhookBatchesWithHttpInfo**](WebhooksApi.md#listWebhookBatchesWithHttpInfo) | **GET** /webhook-batch | Retrieve Webhook Batches |
| [**listWebhooks**](WebhooksApi.md#listWebhooks) | **GET** /webhook | Retrieve Customer Webhooks |
| [**listWebhooksWithHttpInfo**](WebhooksApi.md#listWebhooksWithHttpInfo) | **GET** /webhook | Retrieve Customer Webhooks |
| [**resendWebhookBatch**](WebhooksApi.md#resendWebhookBatch) | **POST** /webhook-batch/{batch_id}/resend | Resend Events |
| [**resendWebhookBatchWithHttpInfo**](WebhooksApi.md#resendWebhookBatchWithHttpInfo) | **POST** /webhook-batch/{batch_id}/resend | Resend Events |
| [**validateWebhook**](WebhooksApi.md#validateWebhook) | **POST** /webhook/validate | Validate Enrolled Webhook |
| [**validateWebhookWithHttpInfo**](WebhooksApi.md#validateWebhookWithHttpInfo) | **POST** /webhook/validate | Validate Enrolled Webhook |



## createWebhook

> void createWebhook(endpoint, xApiKey)

Enroll for Webhook Notifications

Enrolls the customer to receive event notifications via webhooks. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String endpoint = "endpoint_example"; // String | the URL to which the webhook should be sent
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.createWebhook(endpoint, xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#createWebhook");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **endpoint** | **String**| the URL to which the webhook should be sent | |
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
| **201** | Successfully enrolled customer to receive webhooks |  -  |
| **400** | Bad Request |  -  |
| **409** | There&#39;s already a webhook endpoint for this customer |  -  |
| **500** | Internal Server Error |  -  |

## createWebhookWithHttpInfo

> ApiResponse<Void> createWebhookWithHttpInfo(endpoint, xApiKey)

Enroll for Webhook Notifications

Enrolls the customer to receive event notifications via webhooks. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String endpoint = "endpoint_example"; // String | the URL to which the webhook should be sent
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.createWebhookWithHttpInfo(endpoint, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#createWebhook");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **endpoint** | **String**| the URL to which the webhook should be sent | |
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
| **201** | Successfully enrolled customer to receive webhooks |  -  |
| **400** | Bad Request |  -  |
| **409** | There&#39;s already a webhook endpoint for this customer |  -  |
| **500** | Internal Server Error |  -  |


## deleteWebhooks

> void deleteWebhooks(xApiKey)

Delete Customer Webhooks

Deletes all registered webhook endpoints for the customer. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        try {
            apiInstance.deleteWebhooks(xApiKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#deleteWebhooks");
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
| **204** | Successfully removed webhook endpoint(s) |  -  |
| **500** | Internal Server Error |  -  |

## deleteWebhooksWithHttpInfo

> ApiResponse<Void> deleteWebhooksWithHttpInfo(xApiKey)

Delete Customer Webhooks

Deletes all registered webhook endpoints for the customer. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<Void> response = apiInstance.deleteWebhooksWithHttpInfo(xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#deleteWebhooks");
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
| **204** | Successfully removed webhook endpoint(s) |  -  |
| **500** | Internal Server Error |  -  |


## getWebhookSigningKey

> Key getWebhookSigningKey(id)

Retrieve Webhook Signing Key

Retrieves the public key used to verify signatures on incoming webhook payloads. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String id = "id_example"; // String | the ID of the key
        try {
            Key result = apiInstance.getWebhookSigningKey(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#getWebhookSigningKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| the ID of the key | |

### Return type

[**Key**](Key.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully return the webhook signing key |  -  |
| **404** | The key is not found |  -  |
| **500** | Internal Server Error |  -  |

## getWebhookSigningKeyWithHttpInfo

> ApiResponse<Key> getWebhookSigningKeyWithHttpInfo(id)

Retrieve Webhook Signing Key

Retrieves the public key used to verify signatures on incoming webhook payloads. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String id = "id_example"; // String | the ID of the key
        try {
            ApiResponse<Key> response = apiInstance.getWebhookSigningKeyWithHttpInfo(id);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#getWebhookSigningKey");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| the ID of the key | |

### Return type

ApiResponse<[**Key**](Key.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully return the webhook signing key |  -  |
| **404** | The key is not found |  -  |
| **500** | Internal Server Error |  -  |


## listWebhookBatches

> WebhookBatchResult listWebhookBatches(xApiKey, createdAfter, createdBefore, statuses, webhook, limit, offset)

Retrieve Webhook Batches

Retrieves paged webhook batches associated with the customer. The time range specified by created_after and created_before filters must not exceed 31 days. If neither is specified, the default time range is the last 3 days. Optional filters include status categories, webhook, limit and offset. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
import java.util.List;
import java.util.Arrays;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String createdAfter = "createdAfter_example"; // String | Inclusive lower bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        String createdBefore = "createdBefore_example"; // String | Exclusive upper bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        List<String> statuses = Arrays.asList(); // List<String> | Filters webhook batches by webhook response status category. Values must be unique and encoded as a comma-separated list in the query string. If not provided, batches with all categories are returned. 
        String webhook = "webhook_example"; // String | Filters webhook batches by the webhook endpoint to which events in the batch were posted. 
        Integer limit = 500; // Integer | The maximum number of webhook batches to return 
        Integer offset = 0; // Integer | The number of webhook batches to skip before starting to collect the result set 
        try {
            WebhookBatchResult result = apiInstance.listWebhookBatches(xApiKey, createdAfter, createdBefore, statuses, webhook, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#listWebhookBatches");
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
| **createdAfter** | **String**| Inclusive lower bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **createdBefore** | **String**| Exclusive upper bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **statuses** | [**List&lt;String&gt;**](String.md)| Filters webhook batches by webhook response status category. Values must be unique and encoded as a comma-separated list in the query string. If not provided, batches with all categories are returned.  | [optional] [enum: 1xx, 2xx, 3xx, 4xx, 5xx, no_response] |
| **webhook** | **String**| Filters webhook batches by the webhook endpoint to which events in the batch were posted.  | [optional] |
| **limit** | **Integer**| The maximum number of webhook batches to return  | [optional] [default to 500] |
| **offset** | **Integer**| The number of webhook batches to skip before starting to collect the result set  | [optional] [default to 0] |

### Return type

[**WebhookBatchResult**](WebhookBatchResult.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully returned Webhook batches  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

## listWebhookBatchesWithHttpInfo

> ApiResponse<WebhookBatchResult> listWebhookBatchesWithHttpInfo(xApiKey, createdAfter, createdBefore, statuses, webhook, limit, offset)

Retrieve Webhook Batches

Retrieves paged webhook batches associated with the customer. The time range specified by created_after and created_before filters must not exceed 31 days. If neither is specified, the default time range is the last 3 days. Optional filters include status categories, webhook, limit and offset. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
import java.util.List;
import java.util.Arrays;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String createdAfter = "createdAfter_example"; // String | Inclusive lower bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        String createdBefore = "createdBefore_example"; // String | Exclusive upper bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ 
        List<String> statuses = Arrays.asList(); // List<String> | Filters webhook batches by webhook response status category. Values must be unique and encoded as a comma-separated list in the query string. If not provided, batches with all categories are returned. 
        String webhook = "webhook_example"; // String | Filters webhook batches by the webhook endpoint to which events in the batch were posted. 
        Integer limit = 500; // Integer | The maximum number of webhook batches to return 
        Integer offset = 0; // Integer | The number of webhook batches to skip before starting to collect the result set 
        try {
            ApiResponse<WebhookBatchResult> response = apiInstance.listWebhookBatchesWithHttpInfo(xApiKey, createdAfter, createdBefore, statuses, webhook, limit, offset);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#listWebhookBatches");
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
| **createdAfter** | **String**| Inclusive lower bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **createdBefore** | **String**| Exclusive upper bound(UTC) for filtering webhook batches by creation time. Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ  | [optional] |
| **statuses** | [**List&lt;String&gt;**](String.md)| Filters webhook batches by webhook response status category. Values must be unique and encoded as a comma-separated list in the query string. If not provided, batches with all categories are returned.  | [optional] [enum: 1xx, 2xx, 3xx, 4xx, 5xx, no_response] |
| **webhook** | **String**| Filters webhook batches by the webhook endpoint to which events in the batch were posted.  | [optional] |
| **limit** | **Integer**| The maximum number of webhook batches to return  | [optional] [default to 500] |
| **offset** | **Integer**| The number of webhook batches to skip before starting to collect the result set  | [optional] [default to 0] |

### Return type

ApiResponse<[**WebhookBatchResult**](WebhookBatchResult.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully returned Webhook batches  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |


## listWebhooks

> List<Webhook> listWebhooks(xApiKey)

Retrieve Customer Webhooks

Retrieves all registered webhook endpoints associated with the customer. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        try {
            List<Webhook> result = apiInstance.listWebhooks(xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#listWebhooks");
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

### Return type

[**List&lt;Webhook&gt;**](Webhook.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully returning customer&#39;s webhooks |  -  |
| **500** | Internal Server Error |  -  |

## listWebhooksWithHttpInfo

> ApiResponse<List<Webhook>> listWebhooksWithHttpInfo(xApiKey)

Retrieve Customer Webhooks

Retrieves all registered webhook endpoints associated with the customer. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
import java.util.List;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<List<Webhook>> response = apiInstance.listWebhooksWithHttpInfo(xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#listWebhooks");
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

### Return type

ApiResponse<[**List&lt;Webhook&gt;**](Webhook.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully returning customer&#39;s webhooks |  -  |
| **500** | Internal Server Error |  -  |


## resendWebhookBatch

> WebhookResendResponse resendWebhookBatch(batchId, xApiKey)

Resend Events

Synchronously resend the webhook batch with the provided batch_id for the customer. The result is returned in the response. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        Long batchId = 56L; // Long | the ID of the batch
        String xApiKey = "xApiKey_example"; // String | 
        try {
            WebhookResendResponse result = apiInstance.resendWebhookBatch(batchId, xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#resendWebhookBatch");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **batchId** | **Long**| the ID of the batch | |
| **xApiKey** | **String**|  | |

### Return type

[**WebhookResendResponse**](WebhookResendResponse.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Resend attempt completed. The result of the resend attempt is included in the response body. A successful response here does not mean the webhook endpoint responded with a 2xx status code, only that we were able to make the resend attempt and receive a response.  |  -  |
| **400** | Bad Request. The batch ID is invalid. |  -  |
| **404** | The batch ID is not found for the customer. |  -  |
| **500** | Internal Server Error |  -  |

## resendWebhookBatchWithHttpInfo

> ApiResponse<WebhookResendResponse> resendWebhookBatchWithHttpInfo(batchId, xApiKey)

Resend Events

Synchronously resend the webhook batch with the provided batch_id for the customer. The result is returned in the response. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        Long batchId = 56L; // Long | the ID of the batch
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<WebhookResendResponse> response = apiInstance.resendWebhookBatchWithHttpInfo(batchId, xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#resendWebhookBatch");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **batchId** | **Long**| the ID of the batch | |
| **xApiKey** | **String**|  | |

### Return type

ApiResponse<[**WebhookResendResponse**](WebhookResendResponse.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Resend attempt completed. The result of the resend attempt is included in the response body. A successful response here does not mean the webhook endpoint responded with a 2xx status code, only that we were able to make the resend attempt and receive a response.  |  -  |
| **400** | Bad Request. The batch ID is invalid. |  -  |
| **404** | The batch ID is not found for the customer. |  -  |
| **500** | Internal Server Error |  -  |


## validateWebhook

> WebhookValidationResults validateWebhook(xApiKey, webhookValidationRequestBody)

Validate Enrolled Webhook

Validates whether your enrolled webhook(s) respond with an HTTP 2xx status code. Sends a test request to each webhook containing your customer handle, a hardcoded event type(test), a hardcoded sender email(test@mailchannels.com),a timestamp, a request ID (provided or generated), and an SMTP ID. The response includes the HTTP status code and body returned by each webhook. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        WebhookValidationRequestBody webhookValidationRequestBody = new WebhookValidationRequestBody(); // WebhookValidationRequestBody | 
        try {
            WebhookValidationResults result = apiInstance.validateWebhook(xApiKey, webhookValidationRequestBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#validateWebhook");
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
| **webhookValidationRequestBody** | [**WebhookValidationRequestBody**](WebhookValidationRequestBody.md)|  | [optional] |

### Return type

[**WebhookValidationResults**](WebhookValidationResults.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Webhook validation completed  |  -  |
| **400** | Bad Request. Provided request ID is too long. |  -  |
| **404** | No webhooks found for the account |  -  |
| **500** | Internal Server Error |  -  |

## validateWebhookWithHttpInfo

> ApiResponse<WebhookValidationResults> validateWebhookWithHttpInfo(xApiKey, webhookValidationRequestBody)

Validate Enrolled Webhook

Validates whether your enrolled webhook(s) respond with an HTTP 2xx status code. Sends a test request to each webhook containing your customer handle, a hardcoded event type(test), a hardcoded sender email(test@mailchannels.com),a timestamp, a request ID (provided or generated), and an SMTP ID. The response includes the HTTP status code and body returned by each webhook. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.WebhooksApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        WebhooksApi apiInstance = new WebhooksApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        WebhookValidationRequestBody webhookValidationRequestBody = new WebhookValidationRequestBody(); // WebhookValidationRequestBody | 
        try {
            ApiResponse<WebhookValidationResults> response = apiInstance.validateWebhookWithHttpInfo(xApiKey, webhookValidationRequestBody);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhooksApi#validateWebhook");
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
| **webhookValidationRequestBody** | [**WebhookValidationRequestBody**](WebhookValidationRequestBody.md)|  | [optional] |

### Return type

ApiResponse<[**WebhookValidationResults**](WebhookValidationResults.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Webhook validation completed  |  -  |
| **400** | Bad Request. Provided request ID is too long. |  -  |
| **404** | No webhooks found for the account |  -  |
| **500** | Internal Server Error |  -  |

