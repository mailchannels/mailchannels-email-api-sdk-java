import com.mailchannels.api.SendApi;
import com.mailchannels.api.CustomTrackingApi;
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiException;
import com.mailchannels.model.*;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class SendResponseProbe {
  interface Check { void run(ApiClient client) throws Exception; }
  static int passed;
  static void require(boolean condition, String message) { if (!condition) throw new AssertionError(message); }
  static MailSendBody body() { return new MailSendBody().from(new EmailAddress().email("sender@example.invalid"))
    .personalizations(List.of(new Personalization().to(List.of(new EmailAddress().email("recipient@example.invalid")))))
    .content(List.of(new ContentItem().type("text/plain").value("fixture"))).subject("fixture"); }
  static void fixture(String path, int status, String json, Check check) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1",0),0);
    server.createContext(path, exchange -> {
      exchange.getRequestBody().readAllBytes();
      byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type","application/json");
      exchange.sendResponseHeaders(status,bytes.length == 0 ? -1 : bytes.length);
      exchange.getResponseBody().write(bytes); exchange.close();
    });
    server.start();
    try {
      check.run(new ApiClient().setScheme("http").setHost("127.0.0.1").setPort(server.getAddress().getPort()).setBasePath(""));
      passed++; System.out.println("PASS " + path + " HTTP " + status);
    } finally { server.stop(0); }
  }
  public static void main(String[] args) throws Exception {
    fixture("/send",202,"{\"request_id\":\"fixture-request\",\"results\":[{\"index\":0,\"status\":\"sent\",\"message_id\":\"fixture-message\"},{\"index\":1,\"status\":\"failed\",\"reason\":\"fixture rejection\"}]}",client -> {
      var r = new SendApi(client).sendEmailWithHttpInfo("fixture-key",body(),null);
      var data = r.getData(); var results = data.getAccepted();
      require(r.getStatusCode()==202 && data.getDryRun()==null && results.getRequestId().equals("fixture-request") && results.getResults().size()==2 && results.getResults().get(1).getReason().equals("fixture rejection"),"202 results lost");
      require(!data.toString().contains("fixture-request"),"wrapper diagnostics");
    });
    fixture("/send",200,"{\"data\":[\"rendu été\"]}",client -> {
      var r = new SendApi(client).sendEmail("fixture-key",body(),true);
      require(r.getAccepted()==null && r.getDryRun().getData().get(0).equals("rendu été"),"dry-run UTF8/status");
    });
    fixture("/send",202,"",client -> {
      var r = new SendApi(client).sendEmailWithHttpInfo("fixture-key",body(),null);
      require(r.getStatusCode()==202 && (r.getData()==null || r.getData().getAccepted()==null),"empty body");
    });
    fixture("/send",202,"{invalid",client -> {
      boolean failed=false; try {new SendApi(client).sendEmail("fixture-key",body(),null);} catch(ApiException e) {failed=true;}
      require(failed,"malformed JSON silently accepted");
    });
    fixture("/send",203,"{\"future\":\"preserved\"}",client -> {
      var r = new SendApi(client).sendEmail("fixture-key",body(),null);
      require(r.getUnknown().get("future").asText().equals("preserved") && r.getAccepted()==null && r.getDryRun()==null,"unknown success retained");
    });
    String domain="{\"name\":\"fixture\",\"hostname\":\"click.example.invalid\",\"scope\":\"click\",\"status\":\"active\",\"created_at\":\"2026-10-01T00:00:00Z\"}";
    String dns="{\"instructions\":\"fixture DNS required\",\"token\":\"fixture-token\"}";
    for (int status : new int[]{201,202}) fixture("/custom-tracking-domains",status,status==201?domain:dns,client -> {
      var body=client.getObjectMapper().readValue("{\"name\":\"fixture\",\"hostname\":\"click.example.invalid\",\"scope\":\"click\"}",PostCustomTrackingDomainRequest.class);
      var r=new CustomTrackingApi(client).createCustomTrackingDomain("fixture-key",body);
      require(status==201?r.getCreated().getHostname().equals("click.example.invalid") && r.getAccepted()==null:r.getAccepted().getToken().equals("fixture-token") && r.getCreated()==null,"tracking create status");
    });
    for (int status : new int[]{200,202}) fixture("/custom-tracking-domains/click.example.invalid/click",status,status==200?domain:dns,client -> {
      var body=client.getObjectMapper().readValue("{\"status\":\"active\"}",PatchCustomTrackingDomainRequest.class);
      var r=new CustomTrackingApi(client).updateCustomTrackingDomain("click.example.invalid","click","fixture-key",body);
      require(status==200?r.getUpdated().getHostname().equals("click.example.invalid") && r.getAccepted()==null:r.getAccepted().getInstructions().equals("fixture DNS required") && r.getUpdated()==null,"tracking update status");
    });
    System.out.println(passed + " local Java response checks passed; no provider requests.");
  }
}
