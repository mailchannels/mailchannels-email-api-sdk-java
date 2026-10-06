# MetricsApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getEngagementMetrics**](MetricsApi.md#getEngagementMetrics) | **GET** /metrics/engagement | Retrieve Engagement Metrics |
| [**getEngagementMetricsWithHttpInfo**](MetricsApi.md#getEngagementMetricsWithHttpInfo) | **GET** /metrics/engagement | Retrieve Engagement Metrics |
| [**getPerformanceMetrics**](MetricsApi.md#getPerformanceMetrics) | **GET** /metrics/performance | Retrieve Performance Metrics |
| [**getPerformanceMetricsWithHttpInfo**](MetricsApi.md#getPerformanceMetricsWithHttpInfo) | **GET** /metrics/performance | Retrieve Performance Metrics |
| [**getRecipientBehaviourMetrics**](MetricsApi.md#getRecipientBehaviourMetrics) | **GET** /metrics/recipient-behaviour | Retrieve Recipient Behaviour Metrics |
| [**getRecipientBehaviourMetricsWithHttpInfo**](MetricsApi.md#getRecipientBehaviourMetricsWithHttpInfo) | **GET** /metrics/recipient-behaviour | Retrieve Recipient Behaviour Metrics |
| [**getSenderMetrics**](MetricsApi.md#getSenderMetrics) | **GET** /metrics/senders/{sender_type} | Retrieve Sender Metrics |
| [**getSenderMetricsWithHttpInfo**](MetricsApi.md#getSenderMetricsWithHttpInfo) | **GET** /metrics/senders/{sender_type} | Retrieve Sender Metrics |
| [**getVolumeMetrics**](MetricsApi.md#getVolumeMetrics) | **GET** /metrics/volume | Retrieve Volume Metrics |
| [**getVolumeMetricsWithHttpInfo**](MetricsApi.md#getVolumeMetricsWithHttpInfo) | **GET** /metrics/volume | Retrieve Volume Metrics |



## getEngagementMetrics

> MetricsEngagement getEngagementMetrics(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Engagement Metrics

Retrieve engagement metrics for messages sent from your account, including counts of open and click events. Supports optional filters for time range, and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving message engagement metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving message engagement metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            MetricsEngagement result = apiInstance.getEngagementMetrics(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getEngagementMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving message engagement metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving message engagement metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

[**MetricsEngagement**](MetricsEngagement.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved engagement metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

## getEngagementMetricsWithHttpInfo

> ApiResponse<MetricsEngagement> getEngagementMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Engagement Metrics

Retrieve engagement metrics for messages sent from your account, including counts of open and click events. Supports optional filters for time range, and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving message engagement metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving message engagement metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            ApiResponse<MetricsEngagement> response = apiInstance.getEngagementMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getEngagementMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving message engagement metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving message engagement metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

ApiResponse<[**MetricsEngagement**](MetricsEngagement.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved engagement metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |


## getPerformanceMetrics

> MetricsPerformance getPerformanceMetrics(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Performance Metrics

Retrieve performance metrics for messages sent from your account, including counts of processed, delivered, hard-bounced, and complained events. Supports optional filters for time range, and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving message performance metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving message performance metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            MetricsPerformance result = apiInstance.getPerformanceMetrics(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getPerformanceMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving message performance metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving message performance metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

[**MetricsPerformance**](MetricsPerformance.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved performance metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

## getPerformanceMetricsWithHttpInfo

> ApiResponse<MetricsPerformance> getPerformanceMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Performance Metrics

Retrieve performance metrics for messages sent from your account, including counts of processed, delivered, hard-bounced, and complained events. Supports optional filters for time range, and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving message performance metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving message performance metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            ApiResponse<MetricsPerformance> response = apiInstance.getPerformanceMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getPerformanceMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving message performance metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving message performance metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

ApiResponse<[**MetricsPerformance**](MetricsPerformance.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved performance metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |


## getRecipientBehaviourMetrics

> MetricsRecipientBehaviour getRecipientBehaviourMetrics(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Recipient Behaviour Metrics

Retrieve recipient behaviour metrics for messages sent from your account, including counts of unsubscribed events. Supports optional filters for time range, and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving recipient behaviour metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving recipient behaviour metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            MetricsRecipientBehaviour result = apiInstance.getRecipientBehaviourMetrics(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getRecipientBehaviourMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving recipient behaviour metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving recipient behaviour metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

[**MetricsRecipientBehaviour**](MetricsRecipientBehaviour.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved recipient behaviour metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

## getRecipientBehaviourMetricsWithHttpInfo

> ApiResponse<MetricsRecipientBehaviour> getRecipientBehaviourMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Recipient Behaviour Metrics

Retrieve recipient behaviour metrics for messages sent from your account, including counts of unsubscribed events. Supports optional filters for time range, and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving recipient behaviour metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving recipient behaviour metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            ApiResponse<MetricsRecipientBehaviour> response = apiInstance.getRecipientBehaviourMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getRecipientBehaviourMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving recipient behaviour metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving recipient behaviour metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

ApiResponse<[**MetricsRecipientBehaviour**](MetricsRecipientBehaviour.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved recipient behaviour metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |


## getSenderMetrics

> MetricsSenderResponse getSenderMetrics(senderType, xApiKey, startTime, endTime, limit, offset, sortOrder)

Retrieve Sender Metrics

Retrieves a list of senders, either sub-accounts or campaigns, with their associated message metrics. Sorted by total # of sent messages (processed + dropped) Supports optional filter for time range, and optional settings for limit, offset, and sort order. Note: senders without any messages in the given time range will not be included in the results. The default time range is from one month ago to now, and the default sort order is descending. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String senderType = "campaigns"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "startTime_example"; // String | The beginning of the time range for retrieving top senders metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to one month ago if not provided. 
        String endTime = "endTime_example"; // String | The end of the time range for retrieving top senders metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to the current time if not provided. 
        Integer limit = 10; // Integer | The maximum number of senders to return The default is 10. 
        Integer offset = 0; // Integer | The number of senders to skip before returning results. 
        String sortOrder = "asc"; // String | The order in which to sort the results, based on total messages (processed + dropped). 
        try {
            MetricsSenderResponse result = apiInstance.getSenderMetrics(senderType, xApiKey, startTime, endTime, limit, offset, sortOrder);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getSenderMetrics");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **senderType** | **String**|  | [enum: campaigns, sub-accounts] |
| **xApiKey** | **String**|  | |
| **startTime** | **String**| The beginning of the time range for retrieving top senders metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving top senders metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to the current time if not provided.  | [optional] |
| **limit** | **Integer**| The maximum number of senders to return The default is 10.  | [optional] [default to 10] |
| **offset** | **Integer**| The number of senders to skip before returning results.  | [optional] [default to 0] |
| **sortOrder** | **String**| The order in which to sort the results, based on total messages (processed + dropped).  | [optional] [default to desc] [enum: asc, desc] |

### Return type

[**MetricsSenderResponse**](MetricsSenderResponse.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved top senders metrics  |  -  |
| **400** | Invalid request |  -  |
| **500** | Internal server error |  -  |

## getSenderMetricsWithHttpInfo

> ApiResponse<MetricsSenderResponse> getSenderMetricsWithHttpInfo(senderType, xApiKey, startTime, endTime, limit, offset, sortOrder)

Retrieve Sender Metrics

Retrieves a list of senders, either sub-accounts or campaigns, with their associated message metrics. Sorted by total # of sent messages (processed + dropped) Supports optional filter for time range, and optional settings for limit, offset, and sort order. Note: senders without any messages in the given time range will not be included in the results. The default time range is from one month ago to now, and the default sort order is descending. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String senderType = "campaigns"; // String | 
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "startTime_example"; // String | The beginning of the time range for retrieving top senders metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to one month ago if not provided. 
        String endTime = "endTime_example"; // String | The end of the time range for retrieving top senders metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to the current time if not provided. 
        Integer limit = 10; // Integer | The maximum number of senders to return The default is 10. 
        Integer offset = 0; // Integer | The number of senders to skip before returning results. 
        String sortOrder = "asc"; // String | The order in which to sort the results, based on total messages (processed + dropped). 
        try {
            ApiResponse<MetricsSenderResponse> response = apiInstance.getSenderMetricsWithHttpInfo(senderType, xApiKey, startTime, endTime, limit, offset, sortOrder);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getSenderMetrics");
            System.err.println("Status code: " + e.getCode());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **senderType** | **String**|  | [enum: campaigns, sub-accounts] |
| **xApiKey** | **String**|  | |
| **startTime** | **String**| The beginning of the time range for retrieving top senders metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving top senders metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ Defaults to the current time if not provided.  | [optional] |
| **limit** | **Integer**| The maximum number of senders to return The default is 10.  | [optional] [default to 10] |
| **offset** | **Integer**| The number of senders to skip before returning results.  | [optional] [default to 0] |
| **sortOrder** | **String**| The order in which to sort the results, based on total messages (processed + dropped).  | [optional] [default to desc] [enum: asc, desc] |

### Return type

ApiResponse<[**MetricsSenderResponse**](MetricsSenderResponse.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved top senders metrics  |  -  |
| **400** | Invalid request |  -  |
| **500** | Internal server error |  -  |


## getVolumeMetrics

> MetricsVolume getVolumeMetrics(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Volume Metrics

Retrieve volume metrics for messages sent from your account, including counts of processed, delivered and dropped events. Supports optional filters for time range and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving message volume metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving message volume metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            MetricsVolume result = apiInstance.getVolumeMetrics(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getVolumeMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving message volume metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving message volume metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

[**MetricsVolume**](MetricsVolume.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved volume metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

## getVolumeMetricsWithHttpInfo

> ApiResponse<MetricsVolume> getVolumeMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval)

Retrieve Volume Metrics

Retrieve volume metrics for messages sent from your account, including counts of processed, delivered and dropped events. Supports optional filters for time range and campaign ID. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.MetricsApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        MetricsApi apiInstance = new MetricsApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        String startTime = "2025-05-26"; // String | The beginning of the time range for retrieving message volume metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided. 
        String endTime = "2025-05-31T15:16:17Z"; // String | The end of the time range for retrieving message volume metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided. 
        String campaignId = "campaignId_example"; // String | The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned. 
        String interval = "hour"; // String | The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown 
        try {
            ApiResponse<MetricsVolume> response = apiInstance.getVolumeMetricsWithHttpInfo(xApiKey, startTime, endTime, campaignId, interval);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MetricsApi#getVolumeMetrics");
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
| **startTime** | **String**| The beginning of the time range for retrieving message volume metrics (inclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to one month ago if not provided.  | [optional] |
| **endTime** | **String**| The end of the time range for retrieving message volume metrics (exclusive). Formats: YYYY-MM-DD or YYYY-MM-DDTHH:MM:SSZ. Defaults to the current time if not provided.  | [optional] |
| **campaignId** | **String**| The ID of the campaign to filter metrics by. If not provided, metrics for all campaigns will be returned.  | [optional] |
| **interval** | **String**| The interval for aggregating metrics data. Allowed values:   - hour: Hourly breakdown   - day: Daily breakdown (default)   - week: Weekly breakdown   - month: Monthly breakdown  | [optional] [default to day] [enum: hour, day, week, month] |

### Return type

ApiResponse<[**MetricsVolume**](MetricsVolume.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved volume metrics  |  -  |
| **400** | Bad Request |  -  |
| **500** | Internal Server Error |  -  |

