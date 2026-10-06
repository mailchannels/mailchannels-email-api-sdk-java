import com.mailchannels.api.SendApi;
import com.mailchannels.client.ApiClient;
import com.mailchannels.client.ApiException;
import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpsConfigurator;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.*;

public final class TlsProbe {
  static Path directory;
  static int passed;
  static Certificate cert(String name) throws Exception {
    try (var input = Files.newInputStream(directory.resolve(name + ".der"))) {
      return CertificateFactory.getInstance("X.509").generateCertificate(input);
    }
  }
  static SSLContext serverContext(String name) throws Exception {
    var store = KeyStore.getInstance("PKCS12");
    store.load(null, null);
    var key = KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(
        Files.readAllBytes(directory.resolve(name + "-key.der"))));
    char[] password = "local-fixture".toCharArray();
    store.setKeyEntry("server", key, password, new Certificate[]{cert(name), cert("ca")});
    var factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    factory.init(store, password);
    var context = SSLContext.getInstance("TLS");
    context.init(factory.getKeyManagers(), null, null);
    return context;
  }
  static SSLContext clientContext() throws Exception {
    var store = KeyStore.getInstance("PKCS12");
    store.load(null, null);
    store.setCertificateEntry("fixture-ca", cert("ca"));
    var factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    factory.init(store);
    var context = SSLContext.getInstance("TLS");
    context.init(null, factory.getTrustManagers(), null);
    return context;
  }
  static void fixture(String certificate, boolean trustFixture, boolean accepted) throws Exception {
    var requests = new AtomicInteger();
    var server = HttpsServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    server.setHttpsConfigurator(new HttpsConfigurator(serverContext(certificate)));
    server.createContext("/send", exchange -> {
      requests.incrementAndGet();
      exchange.getRequestBody().readAllBytes();
      byte[] bytes = "{\"data\":[\"TLS fixture\"]}".getBytes(java.nio.charset.StandardCharsets.UTF_8);
      exchange.sendResponseHeaders(200, bytes.length);
      exchange.getResponseBody().write(bytes);
      exchange.close();
    });
    server.start();
    try {
      var builder = ApiClient.createDefaultHttpClientBuilder();
      if (trustFixture) builder.sslContext(clientContext());
      var client = new ApiClient().setHttpClientBuilder(builder).setScheme("https")
        .setHost("fixture.test").setPort(server.getAddress().getPort()).setBasePath("");
      ApiException failure = null;
      try {
        var result = new SendApi(client).sendEmail("fixture-key", SendResponseProbe.body(), true);
        TransportProbe.require(result.getDryRun().getData().get(0).equals("TLS fixture"), "TLS response lost");
      } catch (ApiException e) { failure = e; }
      if (accepted) TransportProbe.require(failure == null && requests.get() == 1, "valid TLS rejected");
      else {
        TransportProbe.require(failure != null && failure.getRawCause() instanceof SSLHandshakeException,
          "invalid TLS must fail handshake: " + certificate);
        TransportProbe.require(requests.get() == 0, "invalid TLS reached HTTP handler");
      }
      passed++;
      System.out.println("PASS TLS " + certificate + " trust_fixture=" + trustFixture + " accepted=" + accepted);
    } finally { server.stop(0); }
  }
  public static void main(String[] args) throws Exception {
    directory = Path.of(args[0]);
    fixture("valid", true, true);
    fixture("wrong-host", true, false);
    fixture("expired", true, false);
    fixture("valid", false, false);
    System.out.println("Java TLS checks passed: " + passed);
  }
}
