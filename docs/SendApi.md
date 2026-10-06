# SendApi

All URIs are relative to *https://api.mailchannels.net/tx/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**queueEmail**](SendApi.md#queueEmail) | **POST** /send-async | Send an Email Asynchronously |
| [**queueEmailWithHttpInfo**](SendApi.md#queueEmailWithHttpInfo) | **POST** /send-async | Send an Email Asynchronously |
| [**sendEmail**](SendApi.md#sendEmail) | **POST** /send | Send an Email |
| [**sendEmailWithHttpInfo**](SendApi.md#sendEmailWithHttpInfo) | **POST** /send | Send an Email |



## queueEmail

> AsyncSendResponse queueEmail(xApiKey, mailSendBody)

Send an Email Asynchronously

Queues an email message for asynchronous processing and returns immediately with a request ID.  The email will be processed in the background, and you&#39;ll receive webhook events for all delivery status updates (e.g. dropped, processed, delivered, hard-bounced). These webhook events are identical to those sent for the synchronous /send endpoint.  Use this endpoint when you need to send emails without waiting for processing to complete. This can improve your application&#39;s response time, especially when sending to multiple recipients. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SendApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SendApi apiInstance = new SendApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        MailSendBody mailSendBody = new MailSendBody(); // MailSendBody | 
        try {
            AsyncSendResponse result = apiInstance.queueEmail(xApiKey, mailSendBody);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SendApi#queueEmail");
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
| **mailSendBody** | [**MailSendBody**](MailSendBody.md)|  | |

### Return type

[**AsyncSendResponse**](AsyncSendResponse.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Request accepted and queued for processing |  -  |
| **400** | Bad Request |  -  |
| **403** | User does not have access to this feature |  -  |
| **413** | Payload too large - The total message size should not exceed 30MB. This includes the message itself, headers, and the combined size of any attachments.  |  -  |
| **500** | Internal Server Error |  -  |

## queueEmailWithHttpInfo

> ApiResponse<AsyncSendResponse> queueEmailWithHttpInfo(xApiKey, mailSendBody)

Send an Email Asynchronously

Queues an email message for asynchronous processing and returns immediately with a request ID.  The email will be processed in the background, and you&#39;ll receive webhook events for all delivery status updates (e.g. dropped, processed, delivered, hard-bounced). These webhook events are identical to those sent for the synchronous /send endpoint.  Use this endpoint when you need to send emails without waiting for processing to complete. This can improve your application&#39;s response time, especially when sending to multiple recipients. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SendApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SendApi apiInstance = new SendApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        MailSendBody mailSendBody = new MailSendBody(); // MailSendBody | 
        try {
            ApiResponse<AsyncSendResponse> response = apiInstance.queueEmailWithHttpInfo(xApiKey, mailSendBody);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SendApi#queueEmail");
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
| **mailSendBody** | [**MailSendBody**](MailSendBody.md)|  | |

### Return type

ApiResponse<[**AsyncSendResponse**](AsyncSendResponse.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Request accepted and queued for processing |  -  |
| **400** | Bad Request |  -  |
| **403** | User does not have access to this feature |  -  |
| **413** | Payload too large - The total message size should not exceed 30MB. This includes the message itself, headers, and the combined size of any attachments.  |  -  |
| **500** | Internal Server Error |  -  |


## sendEmail

> SendEmailResult sendEmail(xApiKey, mailSendBody, dryRun)

Send an Email

Sends an email message to one or more recipients.  **Click Tracking Notes:** Only links (&#x60;&lt;a&gt;&#x60; tags) meeting all of the following conditions are processed for click tracking: - The URL is non-empty. - The URL starts with \&quot;http\&quot; or \&quot;https\&quot;. - The link does not have a clicktracking attribute set to &#39;off&#39;. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SendApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SendApi apiInstance = new SendApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        MailSendBody mailSendBody = new MailSendBody(); // MailSendBody | 
        Boolean dryRun = true; // Boolean | When present and set to true, the message will not be sent. Instead, the fully rendered message is returned. This can be useful for testing. 
        try {
            SendEmailResult result = apiInstance.sendEmail(xApiKey, mailSendBody, dryRun);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SendApi#sendEmail");
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
| **mailSendBody** | [**MailSendBody**](MailSendBody.md)|  | |
| **dryRun** | **Boolean**| When present and set to true, the message will not be sent. Instead, the fully rendered message is returned. This can be useful for testing.  | [optional] |

### Return type

[**SendEmailResult**](SendEmailResult.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. Returned if dry-run is present in the query |  -  |
| **202** | Success |  -  |
| **400** | Bad Request |  -  |
| **403** | User does not have access to this feature |  -  |
| **413** | Payload too large - The total message size should not exceed 30MB. This includes the message itself, headers, and the combined size of any attachments.  |  -  |
| **500** | Internal Server Error |  -  |
| **502** | Bad Gateway |  -  |

## sendEmailWithHttpInfo

> ApiResponse<SendEmailResult> sendEmailWithHttpInfo(xApiKey, mailSendBody, dryRun)

Send an Email

Sends an email message to one or more recipients.  **Click Tracking Notes:** Only links (&#x60;&lt;a&gt;&#x60; tags) meeting all of the following conditions are processed for click tracking: - The URL is non-empty. - The URL starts with \&quot;http\&quot; or \&quot;https\&quot;. - The link does not have a clicktracking attribute set to &#39;off&#39;. 

### Example

```java
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiResponse;
import com.mailchannels.client.ApiException;
import com.mailchannels.client.Configuration;
import com.mailchannels.model.*;
import com.mailchannels.api.SendApi;
// Import classes:

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // ApiClient already uses the MailChannels HTTPS endpoint.

        SendApi apiInstance = new SendApi(defaultClient);
        String xApiKey = "xApiKey_example"; // String | 
        MailSendBody mailSendBody = new MailSendBody(); // MailSendBody | 
        Boolean dryRun = true; // Boolean | When present and set to true, the message will not be sent. Instead, the fully rendered message is returned. This can be useful for testing. 
        try {
            ApiResponse<SendEmailResult> response = apiInstance.sendEmailWithHttpInfo(xApiKey, mailSendBody, dryRun);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SendApi#sendEmail");
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
| **mailSendBody** | [**MailSendBody**](MailSendBody.md)|  | |
| **dryRun** | **Boolean**| When present and set to true, the message will not be sent. Instead, the fully rendered message is returned. This can be useful for testing.  | [optional] |

### Return type

ApiResponse<[**SendEmailResult**](SendEmailResult.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. Returned if dry-run is present in the query |  -  |
| **202** | Success |  -  |
| **400** | Bad Request |  -  |
| **403** | User does not have access to this feature |  -  |
| **413** | Payload too large - The total message size should not exceed 30MB. This includes the message itself, headers, and the combined size of any attachments.  |  -  |
| **500** | Internal Server Error |  -  |
| **502** | Bad Gateway |  -  |

