import com.mailchannels.client.ApiException;
import com.mailchannels.client.ApiClient;
import com.mailchannels.model.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.http.HttpHeaders;
import java.util.Map;
import java.util.List;

public final class DiagnosticsProbe {
  static final String SECRET="fixture-sensitive-canary";
  static void require(boolean ok, String message) {if(!ok) throw new AssertionError(message);}
  public static void main(String[] args) throws Exception {
    var body=SendResponseProbe.body().subject(SECRET).dkimPrivateKey(SECRET);
    require(!body.toString().contains(SECRET),"model ToString leaks message/DKIM data");
    require(!new EmailAddress().email(SECRET).toString().contains(SECRET),"email formatting");
    require(!new APIKey().key(SECRET).toString().contains(SECRET),"key formatting");
    require(ApiClient.createDefaultObjectMapper().writeValueAsString(body).contains(SECRET),"explicit serialization lost data");
    System.out.println("PASS model diagnostics redacted; explicit serialization retained");
    var response=new ApiException(400,"error "+SECRET,HttpHeaders.of(Map.of("x-fixture",List.of(SECRET)),(a,b)->true),SECRET);
    require(!response.toString().contains(SECRET) && !response.getMessage().contains(SECRET),"HTTP error message leak");
    require(response.getRawMessage().contains(SECRET),"explicit raw message lost");
    require(response.getResponseBody().equals(SECRET) && response.getResponseHeaders().firstValue("x-fixture").get().equals(SECRET),"explicit error data lost");
    System.out.println("PASS response exception formatting redacted");
    var wrapped=new ApiException(new IllegalArgumentException(SECRET));
    StringWriter output=new StringWriter(); wrapped.printStackTrace(new PrintWriter(output));
    require(!output.toString().contains(SECRET),"exception chain leaks data");
    require(wrapped.getRawCause().getMessage().equals(SECRET) && wrapped.getCause()==null,"explicit raw cause contract");
    System.out.println("PASS exception stack trace redacted");
    System.out.println("3 Java diagnostic checks passed");
  }
}
