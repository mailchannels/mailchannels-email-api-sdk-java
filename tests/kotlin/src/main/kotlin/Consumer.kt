import com.mailchannels.api.SendApi
import com.mailchannels.api.SubAccountsApi
import com.mailchannels.api.WebhooksApi
import com.mailchannels.client.ApiClient
import com.mailchannels.client.ApiException
import com.mailchannels.model.*
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

private var passed = 0
private fun fixture(path: String, status: Int, response: String, check: (ApiClient) -> Unit) {
    val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
    var calls = 0
    server.createContext(path) { exchange ->
        calls++
        exchange.requestBody.readAllBytes()
        val bytes = response.toByteArray(Charsets.UTF_8)
        exchange.responseHeaders.set("Content-Type", "application/json")
        exchange.sendResponseHeaders(status, if (bytes.isEmpty()) -1 else bytes.size.toLong())
        if (bytes.isNotEmpty()) exchange.responseBody.write(bytes)
        exchange.close()
    }
    server.start()
    try {
        check(ApiClient().setScheme("http").setHost("127.0.0.1").setPort(server.address.port).setBasePath(""))
        check(calls == 1)
        passed++
        println("PASS Kotlin $path status=$status")
    } finally { server.stop(0) }
}
private fun body() = MailSendBody()
    .from(EmailAddress().email("sender@example.invalid"))
    .personalizations(listOf(Personalization().to(listOf(EmailAddress().email("recipient@example.invalid")))))
    .content(listOf(ContentItem().type("text/plain").value("Kotlin fixture")))
    .subject("Kotlin fixture")

fun main() {
    fixture("/send", 200, """{"data":["rendu été"]}""") { client ->
        val result = SendApi(client).sendEmail("fixture-key", body(), true)
        check(requireNotNull(result.dryRun.data).single() == "rendu été" && result.accepted == null)
    }
    fixture("/send", 202, """{"request_id":"fixture-request","results":[{"index":0,"status":"sent","message_id":"fixture-message"},{"index":1,"status":"failed","reason":"fixture rejection"}]}""") { client ->
        val result = SendApi(client).sendEmail("fixture-key", body(), null)
        check(result.dryRun == null && result.accepted.requestId == "fixture-request")
        check(requireNotNull(result.accepted.results)[1].reason == "fixture rejection")
        check(!result.toString().contains("fixture-request"))
    }
    fixture("/sub-account", 201, """{"handle":"generated","enabled":true}""") { client ->
        check(SubAccountsApi(client).createSubaccount("fixture-key", null).handle == "generated")
    }
    fixture("/webhook-batch/4294967296/resend", 200, """{"batch_id":4294967296,"customer_handle":"fixture","webhook":"https://example.invalid/hook","created_at":"2026-10-01T00:00:00Z","event_count":2,"status_code":null,"duration_in_ms":null}""") { client ->
        val result = WebhooksApi(client).resendWebhookBatch(4294967296L, "fixture-key")
        check(result.batchId == 4294967296L && result.statusCode == null)
    }
    fixture("/send", 400, """{"errors":["fixture raw error"]}""") { client ->
        val error = try { SendApi(client).sendEmail("fixture-key", body(), true); error("Expected failure") }
                    catch (failure: ApiException) { failure }
        check(error.code == 400 && error.responseBody.contains("fixture raw error"))
        check(!error.toString().contains("fixture raw error"))
    }
    println("Kotlin package consumer checks passed: $passed")
}
