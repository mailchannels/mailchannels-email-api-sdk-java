import com.mailchannels.api.SendApi;
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiException;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.net.http.HttpClient;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public final class TransportProbe {
  static int passed;
  static void require(boolean ok, String message) { if (!ok) throw new AssertionError(message); }
  static void fixture(String mode, int status) throws Exception {
    var count = new AtomicInteger();
    var server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    server.createContext("/", exchange -> {
      count.incrementAndGet();
      try {
        exchange.getRequestBody().readAllBytes();
        if (mode.equals("headers")) Thread.sleep(1600);
        exchange.getResponseHeaders().set("Location", "/redirect-target");
        byte[] body = "{}".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, body.length);
        if (mode.equals("body")) { exchange.getResponseBody().write('{'); exchange.getResponseBody().flush(); Thread.sleep(1600); exchange.getResponseBody().write('}'); }
        else exchange.getResponseBody().write(body);
      } catch (Exception ignored) { /* Expected when the timed-out client disconnects. */ }
      finally { exchange.close(); }
    });
    server.start();
    try {
      var client = new ApiClient().setScheme("http").setHost("127.0.0.1")
        .setPort(server.getAddress().getPort()).setBasePath("").setReadTimeout(Duration.ofMillis(400));
      long start = System.nanoTime();
      ApiException failure = null;
      try { new SendApi(client).sendEmail("fixture-key", SendResponseProbe.body(), true); }
      catch (ApiException e) { failure = e; }
      long elapsed = (System.nanoTime() - start) / 1_000_000;
      require(failure != null, mode + " expected failure");
      if (mode.equals("headers") || mode.equals("body")) {
        require(failure.getRawCause() instanceof HttpTimeoutException, mode + " expected timeout");
        require(elapsed < 1300, mode + " body deadline not enforced: " + elapsed);
      } else require(failure.getCode() == status, mode + " status lost");
      require(count.get() == 1, mode + " retried or followed redirect");
      System.out.println("PASS transport " + mode + " status=" + status + " elapsed_ms=" + elapsed);
      passed++;
    } finally { server.stop(0); }
  }
  public static void main(String[] args) throws Exception {
    fixture("headers", 200);
    fixture("body", 200);
    fixture("redirect302", 302);
    fixture("redirect307", 307);
    fixture("unavailable", 503);
    var client = ApiClient.createDefaultHttpClientBuilder().build();
    require(client.followRedirects() == HttpClient.Redirect.NEVER, "default redirects");
    require(client.connectTimeout().orElseThrow().equals(Duration.ofSeconds(10)), "connect default");
    require(new ApiClient().getReadTimeout().equals(Duration.ofSeconds(30)), "response default");
    passed++;
    System.out.println("Java transport checks passed: " + passed);
  }
}
