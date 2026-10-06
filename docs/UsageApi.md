# UsageApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getUsage**](UsageApi.md#getUsage) | **GET** /usage | Retrieve Usage Stats |
| [**getUsageWithHttpInfo**](UsageApi.md#getUsageWithHttpInfo) | **GET** /usage | Retrieve Usage Stats |



## getUsage

> UsageStats getUsage(xApiKey)

Retrieve Usage Stats

Retrieves usage statistics during the current billing period.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.UsageApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        UsageApi apiInstance = new UsageApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        try {
            UsageStats result = apiInstance.getUsage(xApiKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UsageApi#getUsage");
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
| **500** | Internal Server Error |  -  |

## getUsageWithHttpInfo

> ApiResponse<UsageStats> getUsageWithHttpInfo(xApiKey)

Retrieve Usage Stats

Retrieves usage statistics during the current billing period.

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.UsageApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        UsageApi apiInstance = new UsageApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        try {
            ApiResponse<UsageStats> response = apiInstance.getUsageWithHttpInfo(xApiKey);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling UsageApi#getUsage");
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
| **500** | Internal Server Error |  -  |

