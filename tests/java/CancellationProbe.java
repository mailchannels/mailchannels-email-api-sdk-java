import com.mailchannels.api.UsageApi;
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.http.HttpClient;
import java.net.http.HttpTimeoutException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/** Observe cancellation at the peer socket, not merely the returned exception. */
public final class CancellationProbe {
  static void fixture(boolean interrupt) throws Exception {
    var started = new CountDownLatch(1);
    var closed = new CountDownLatch(1);
    var serverFailure = new AtomicReference<Throwable>();
    var callerFailure = new AtomicReference<Throwable>();
    try (var listener = new ServerSocket(0, 1, InetAddress.getByName("127.0.0.1"))) {
      listener.setSoTimeout(5000);
      var peer = new Thread(() -> {
        try (var socket = listener.accept()) {
          socket.setSoTimeout(4000);
          var input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));
          String line = input.readLine();
          ContractFixture.require(line != null && line.startsWith("GET /usage HTTP/1.1"), "fixture request");
          while ((line = input.readLine()) != null && !line.isEmpty()) {}
          socket.getOutputStream().write(("HTTP/1.1 200 OK\r\nContent-Type: application/json\r\nContent-Length: 2\r\n\r\n{").getBytes(StandardCharsets.US_ASCII));
          socket.getOutputStream().flush();
          started.countDown();
          try {
            ContractFixture.require(input.read() == -1, "cancelled connection sent unexpected bytes");
          } catch (SocketException reset) { /* Reset is also peer-visible cancellation. */ }
          closed.countDown();
        } catch (Throwable error) { serverFailure.set(error); }
      }, "fixture-peer");
      var client = new ApiClient().setHttpClientBuilder(ApiClient.createDefaultHttpClientBuilder().version(HttpClient.Version.HTTP_1_1))
        .setScheme("http").setHost("127.0.0.1").setPort(listener.getLocalPort()).setBasePath("")
        .setReadTimeout(Duration.ofSeconds(interrupt ? 20 : 1));
      var caller = new Thread(() -> {
        try {
          new UsageApi(client).getUsage("fixture-key");
          callerFailure.set(new AssertionError("stalled request succeeded"));
        } catch (ApiException error) {
          boolean valid = interrupt
            ? error.getRawCause() instanceof InterruptedException && Thread.currentThread().isInterrupted()
            : error.getRawCause() instanceof HttpTimeoutException;
          if (!valid) callerFailure.set(new AssertionError("wrong cancellation exception/interrupt state"));
        } catch (Throwable error) { callerFailure.set(error); }
      }, "fixture-caller");
      peer.start(); caller.start();
      try {
        ContractFixture.require(started.await(3, TimeUnit.SECONDS), "response did not start");
        if (interrupt) caller.interrupt();
        caller.join(3000);
        ContractFixture.require(!caller.isAlive(), "caller did not terminate");
        ContractFixture.require(callerFailure.get() == null, "caller failure: " + callerFailure.get());
        ContractFixture.require(closed.await(3, TimeUnit.SECONDS), "cancelled request left peer socket open");
        peer.join(1000);
        ContractFixture.require(serverFailure.get() == null, "peer failure: " + serverFailure.get());
        System.out.println("PASS " + (interrupt ? "interrupt flag restored" : "deadline raised") + "; stalled HTTP/1.1 peer socket closed");
      } finally {
        caller.interrupt(); listener.close();
        caller.join(3000); peer.join(5000);
      }
    }
  }
  static void alreadyInterrupted() throws Exception {
    var failure = new AtomicReference<Throwable>();
    try (var listener = new ServerSocket(0, 1, InetAddress.getByName("127.0.0.1"))) {
      listener.setSoTimeout(1500);
      var client = new ApiClient().setHttpClientBuilder(ApiClient.createDefaultHttpClientBuilder().version(HttpClient.Version.HTTP_1_1))
          .setScheme("http").setHost("127.0.0.1").setPort(listener.getLocalPort()).setBasePath("")
          .setReadTimeout(Duration.ofSeconds(2));
      var caller = new Thread(() -> {
        Thread.currentThread().interrupt();
        try {
          new UsageApi(client).getUsage("fixture-key");
          failure.set(new AssertionError("already-interrupted call succeeded"));
        } catch (ApiException error) {
          if (!(error.getRawCause() instanceof InterruptedException) || !Thread.currentThread().isInterrupted())
            failure.set(new AssertionError("interrupt cause/flag not preserved"));
        } catch (Throwable error) { failure.set(error); }
      }, "already-interrupted-caller");
      caller.start(); caller.join(3000);
      ContractFixture.require(!caller.isAlive(), "already-interrupted caller did not return");
      ContractFixture.require(failure.get() == null, "caller failure: " + failure.get());
      try (var unexpected = listener.accept()) {
        throw new AssertionError("already-interrupted call opened a network connection");
      } catch (java.net.SocketTimeoutException expected) {
        System.out.println("PASS already-interrupted call: no peer connection; cause and flag preserved");
      }
    }
  }
  public static void main(String[] args) throws Exception {
    alreadyInterrupted();
    fixture(true);
    fixture(false);
    System.out.println("Java cancellation checks passed: 3");
  }
}
