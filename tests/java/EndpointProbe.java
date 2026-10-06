import com.mailchannels.api.*;
import com.mailchannels.model.*;
import java.util.*;

public final class EndpointProbe {
  static void require(boolean ok, String message) { ContractFixture.require(ok,message); }
  public static void main(String[] args) throws Exception {
    ContractFixture.run("POST","/send-async",202,"{\"request_id\":\"queued-fixture\",\"queued_at\":\"2026-10-06T00:00:00Z\"}",true,(c,h)->{
      var r=new SendApi(c).queueEmail("fixture-key",SendResponseProbe.body());
      require(r.getRequestId().equals("queued-fixture"),"async receipt");
      require(c.getObjectMapper().readTree(h.body).get("from").get("email").asText().equals("sender@example.invalid"),"async body");
    });
    String endpoint="https://example.invalid/hook?a=1&token=fixture+value#frag";
    ContractFixture.run("POST","/webhook",201,"",true,(c,h)->{
      require(new WebhooksApi(c).createWebhookWithHttpInfo(endpoint,"fixture-key").getStatusCode()==201,"create webhook");
      require(h.query().equals(Map.of("endpoint",endpoint)) && h.body.isEmpty(),"endpoint encoding");
    });
    ContractFixture.run("GET","/webhook",200,"[{\"webhook\":\"https://example.invalid/a\"},{\"webhook\":\"https://example.invalid/b\"}]",true,(c,h)->{
      var r=new WebhooksApi(c).listWebhooks("fixture-key");
      require(r.size()==2 && r.get(1).getWebhook().equals("https://example.invalid/b"),"webhook list");
    });
    ContractFixture.run("DELETE","/webhook",204,"",true,(c,h)->{
      require(new WebhooksApi(c).deleteWebhooksWithHttpInfo("fixture-key").getStatusCode()==204 && h.body.isEmpty(),"delete webhook");
    });
    ContractFixture.run("GET","/webhook/public-key",200,"{\"id\":\"fixture+key\",\"key\":\"fixture-public-key\"}",false,(c,h)->{
      var r=new WebhooksApi(c).getWebhookSigningKey("fixture+key");
      require(r.getId().equals("fixture+key") && r.getKey().equals("fixture-public-key") && h.query().equals(Map.of("id","fixture+key")),"signing key");
    });
    ContractFixture.run("GET","/webhook-batch",200,"{\"webhook_batches\":[{\"batch_id\":4294967296,\"customer_handle\":\"fixture\",\"webhook\":\"https://example.invalid/hook\",\"status\":\"no_response\",\"status_code\":null,\"created_at\":\"2026-10-01T00:00:00Z\",\"event_count\":2}]}",true,(c,h)->{
      var r=new WebhooksApi(c).listWebhookBatches("fixture-key","2026-10-01","2026-10-02",List.of("no_response","5xx"),endpoint,10,20).getWebhookBatches().get(0);
      require(r.getBatchId()==4294967296L && r.getStatusCode()==null && r.getEventCount()==2,"batch data");
      require(h.query().equals(Map.of("created_after","2026-10-01","created_before","2026-10-02","statuses","no_response,5xx","webhook",endpoint,"limit","10","offset","20")),"batch filters");
    });
    ContractFixture.run("POST","/webhook-batch/4294967296/resend",200,"{\"batch_id\":4294967296,\"customer_handle\":\"fixture\",\"webhook\":\"https://example.invalid/hook\",\"created_at\":\"2026-10-01T00:00:00Z\",\"event_count\":2,\"status_code\":null,\"duration_in_ms\":null}",true,(c,h)->{
      var r=new WebhooksApi(c).resendWebhookBatch(4294967296L,"fixture-key");
      require(r.getBatchId()==4294967296L && r.getStatusCode()==null && r.getDurationInMs()==null,"resend receipt");
    });
    ContractFixture.run("POST","/webhook/validate",200,"{\"all_passed\":false,\"results\":[]}",true,(c,h)->{
      var r=new WebhooksApi(c).validateWebhook("fixture-key",new WebhookValidationRequestBody().requestId("fixture-request"));
      require(!r.getAllPassed() && r.getResults().isEmpty(),"validation response");
      require(c.getObjectMapper().readTree(h.body).get("request_id").asText().equals("fixture-request"),"validation request");
    });

    ContractFixture.run("POST","/suppression-list",201,"",true,(c,h)->{
      var input=new SuppressionListInput().addToSubAccounts(true).suppressionEntries(List.of(
        new SuppressionEntry().recipient("one+tag@example.invalid").notes(null).suppressionTypes(List.of(
          SuppressionEntry.SuppressionTypesEnum.TRANSACTIONAL,SuppressionEntry.SuppressionTypesEnum.NON_TRANSACTIONAL))));
      require(new SuppressionApi(c).createSuppressionsWithHttpInfo("fixture-key",input).getStatusCode()==201,"suppression status");
      var root=c.getObjectMapper().readTree(h.body); var entry=root.get("suppression_entries").get(0);
      require(root.get("add_to_sub_accounts").asBoolean() && entry.get("notes").isNull()
        && entry.get("suppression_types").get(1).asText().equals("non-transactional"),"nullable notes and enum wire value");
    });
    ContractFixture.run("GET","/suppression-list",200,"{\"suppression_list\":[{\"recipient\":\"one+tag@example.invalid\",\"sender\":null,\"notes\":null,\"source\":\"spam_complaint\",\"created_at\":\"2026-10-01T00:00:00Z\",\"suppression_types\":[\"non-transactional\"]}]}",true,(c,h)->{
      var r=new SuppressionApi(c).listSuppressions("fixture-key","one+tag@example.invalid","spam_complaint","2026-10-02","2026-10-01",5,10).getSuppressionList().get(0);
      require(r.getRecipient().equals("one+tag@example.invalid") && r.getSender()==null && r.getNotes()==null
        && r.getSource().toString().equals("spam_complaint") && r.getSuppressionTypes().get(0).toString().equals("non-transactional"),"suppression result");
      require(h.query().equals(Map.of("recipient","one+tag@example.invalid","source","spam_complaint","created_before","2026-10-02","created_after","2026-10-01","limit","5","offset","10")),"suppression filters");
    });
    for (String scope : new String[]{null,"all"})
      ContractFixture.run("DELETE","/suppression-list/recipients/one%2Btag%40example.invalid",204,"",true,(c,h)->{
        require(new SuppressionApi(c).deleteSuppressionWithHttpInfo("one+tag@example.invalid","fixture-key",scope).getStatusCode()==204,"suppression delete");
        require(h.body.isEmpty() && h.query().equals(scope==null?Map.of():Map.of("source","all")),"delete scope");
      });
    System.out.println("Java endpoint contract checks passed: " + ContractFixture.passed);
  }
}
