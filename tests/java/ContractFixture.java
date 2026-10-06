import com.mailchannels.client.ApiClient;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

final class ContractFixture {
  interface Check { void run(ApiClient client, ContractFixture request) throws Exception; }
  String method, key, body, contentType;
  URI uri;
  int count;
  static int passed;
  Map<String,String> query() {
    Map<String,String> result = new HashMap<>();
    if (uri.getRawQuery() != null) for (String part : uri.getRawQuery().split("&")) {
      String[] pair = part.split("=",2);
      String k=URLDecoder.decode(pair[0],StandardCharsets.UTF_8);
      String v=URLDecoder.decode(pair.length>1?pair[1]:"",StandardCharsets.UTF_8);
      result.merge(k,v,(a,b)->a+","+b);
    }
    return result;
  }
  static void require(boolean ok, String reason) { if (!ok) throw new AssertionError(reason); }
  static void run(String method, String path, int status, String json, boolean authenticated, Check check) throws Exception {
    var request = new ContractFixture();
    var server = HttpServer.create(new InetSocketAddress("127.0.0.1",0),0);
    server.createContext("/", exchange -> {
      request.count++; request.method=exchange.getRequestMethod(); request.uri=exchange.getRequestURI();
      request.contentType=exchange.getRequestHeaders().getFirst("Content-Type");
      request.key=exchange.getRequestHeaders().getFirst("X-Api-Key");
      request.body=new String(exchange.getRequestBody().readAllBytes(),StandardCharsets.UTF_8);
      byte[] bytes=json.getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type","application/json");
      exchange.sendResponseHeaders(status,bytes.length==0?-1:bytes.length);
      if(bytes.length>0) exchange.getResponseBody().write(bytes);
      exchange.close();
    });
    server.start();
    try {
      check.run(new ApiClient().setScheme("http").setHost("127.0.0.1").setPort(server.getAddress().getPort()).setBasePath(""),request);
      require(request.count==1 && method.equals(request.method) && path.equals(request.uri.getRawPath()),"request method/path/count: " + method + " " + path);
      require(authenticated ? "fixture-key".equals(request.key) : request.key==null,"authentication header");
      passed++; System.out.println("PASS contract " + method + " " + path);
    } finally {server.stop(0);}
  }
}
