import com.mailchannels.api.*;
import com.mailchannels.model.*;
import java.util.*;
public final class ManagementProbe {
  static void require(boolean ok,String why) { ContractFixture.require(ok,why); }
  static void checkBuckets(com.fasterxml.jackson.databind.JsonNode actual, com.fasterxml.jackson.databind.JsonNode expected) {
    expected.fields().forEachRemaining(entry -> require(entry.getValue().equals(actual.get(entry.getKey())), "metric bucket " + entry.getKey()));
  }
  public static void main(String[] args) throws Exception {
    ContractFixture.run("POST","/check-domain",200,"{\"check_results\":{\"dkim\":[{\"verdict\":\"failed\",\"reason\":\"fixture mismatch\"}]},\"references\":[\"https://example.invalid/help\"]}",true,(c,h)->{
      var r=new DkimApi(c).checkDomain("fixture-key",c.getObjectMapper().readValue("{\"domain\":\"example.invalid\",\"envelope_from_domain\":\"bounce.example.invalid\",\"sender_id\":\"fixture\",\"dkim_settings\":[{\"dkim_domain\":\"example.invalid\",\"dkim_selector\":\"fixture\"}]}",CheckDomainBody.class)); require(c.getObjectMapper().valueToTree(r).at("/check_results/dkim/0/verdict").asText().equals("failed"),"domain verdict"); require(c.getObjectMapper().readTree(h.body).equals(c.getObjectMapper().readTree("{\"domain\":\"example.invalid\",\"envelope_from_domain\":\"bounce.example.invalid\",\"sender_id\":\"fixture\",\"dkim_settings\":[{\"dkim_domain\":\"example.invalid\",\"dkim_selector\":\"fixture\"}]}")),"request body");
    });
    ContractFixture.run("POST","/domains/example.invalid/dkim-keys",201,"{\"domain\":\"example.invalid\",\"selector\":\"fixture\",\"public_key\":\"fixture-public-key\",\"status\":\"active\",\"algorithm\":\"rsa\",\"created_at\":null,\"key_length\":2048,\"dkim_dns_records\":[{\"name\":\"fixture._domainkey.example.invalid\",\"type\":\"TXT\",\"value\":\"fixture-dns\"}]}",true,(c,h)->{
      var r=new DkimApi(c).createDkimKey("example.invalid","fixture-key",c.getObjectMapper().readValue("{\"selector\":\"fixture\",\"algorithm\":\"rsa\",\"key_length\":2048}",DKIMKeyPairCreateRequest.class)); require(r.getSelector().equals("fixture") && c.getObjectMapper().valueToTree(r).at("/dkim_dns_records/0/type").asText().equals("TXT"),"DKIM key"); require(c.getObjectMapper().readTree(h.body).equals(c.getObjectMapper().readTree("{\"selector\":\"fixture\",\"algorithm\":\"rsa\",\"key_length\":2048}")),"request body");
    });
    ContractFixture.run("GET","/domains/example.invalid/dkim-keys",200,"{\"keys\":[]}",true,(c,h)->{
      var r=new DkimApi(c).listDkimKeys("example.invalid","fixture-key","fixture","active",10,5,true); require(r.getKeys().isEmpty() && h.query().equals(Map.of("selector","fixture","status","active","offset","10","limit","5","include_dns_record","true")),"DKIM list");
    });
    ContractFixture.run("POST","/domains/example.invalid/dkim-keys/old/rotate",201,"{\"new_key\":{\"domain\":\"example.invalid\",\"selector\":\"new\",\"public_key\":\"new-public\",\"status\":\"active\",\"algorithm\":\"rsa\"},\"rotated_key\":{\"domain\":\"example.invalid\",\"selector\":\"old\",\"public_key\":\"old-public\",\"status\":\"rotated\",\"algorithm\":\"rsa\",\"retiresAt\":null,\"gracePeriodExpiresAt\":null}}",true,(c,h)->{
      var r=new DkimApi(c).rotateDkimKey("example.invalid","old","fixture-key",c.getObjectMapper().readValue("{\"new_key\":{\"selector\":\"new\"}}",DKIMKeyRotateRequest.class)); require(r.getNewKey().getSelector().equals("new") && r.getRotatedKey().getSelector().equals("old"),"rotation keys"); require(c.getObjectMapper().readTree(h.body).equals(c.getObjectMapper().readTree("{\"new_key\":{\"selector\":\"new\"}}")),"request body");
    });
    ContractFixture.run("PATCH","/domains/example.invalid/dkim-keys/fixture",204,"",true,(c,h)->{
      require(new DkimApi(c).updateDkimKeyWithHttpInfo("example.invalid","fixture","fixture-key",c.getObjectMapper().readValue("{\"status\":\"revoked\"}",DKIMKeyPairUpdateRequest.class)).getStatusCode()==204,"revoke key"); require(c.getObjectMapper().readTree(h.body).equals(c.getObjectMapper().readTree("{\"status\":\"revoked\"}")),"request body");
    });
    ContractFixture.run("GET","/custom-tracking-domains",200,"{\"custom_tracking_domains\":[],\"total\":0}",true,(c,h)->{
      var r=new CustomTrackingApi(c).listCustomTrackingDomains("fixture-key","fixture","active","click",5,10); require(r.getTotal()==0 && r.getCustomTrackingDomains().isEmpty() && h.query().equals(Map.of("name","fixture","status","active","scope","click","limit","5","offset","10")),"tracking list");
    });
    ContractFixture.run("DELETE","/custom-tracking-domains/click.example.invalid/click",204,"",true,(c,h)->{
      require(new CustomTrackingApi(c).deleteCustomTrackingDomainWithHttpInfo("click.example.invalid","click","fixture-key").getStatusCode()==204 && h.body.isEmpty(),"tracking delete");
    });
    ContractFixture.run("GET","/metrics/engagement",200,"{\"open\":3,\"open_tracking_delivered\":4,\"click\":2,\"click_tracking_delivered\":4,\"unique_open\":2,\"unique_click\":1,\"buckets\":{\"open\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":3}],\"open_tracking_delivered\":[],\"click\":[],\"click_tracking_delivered\":[]}}",true,(c,h)->{
      var r=new MetricsApi(c).getEngagementMetrics("fixture-key","2026-10-01T00:00:00Z","2026-10-02T00:00:00Z","fixture+campaign","day"); require(r.getUniqueClick()==1 && r.getBuckets()!=null,"metric value/buckets"); checkBuckets(c.getObjectMapper().readTree(c.getObjectMapper().writeValueAsString(r)).get("buckets"), c.getObjectMapper().readTree("{\"open\":3,\"open_tracking_delivered\":4,\"click\":2,\"click_tracking_delivered\":4,\"unique_open\":2,\"unique_click\":1,\"buckets\":{\"open\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":3}],\"open_tracking_delivered\":[],\"click\":[],\"click_tracking_delivered\":[]}}").get("buckets")); require(h.query().equals(Map.of("start_time","2026-10-01T00:00:00Z","end_time","2026-10-02T00:00:00Z","campaign_id","fixture+campaign","interval","day")),"metric filters");
    });
    ContractFixture.run("GET","/metrics/performance",200,"{\"delivered\":10,\"bounced\":2,\"complained\":1,\"processed\":12,\"buckets\":{\"delivered\":[],\"bounced\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":2}],\"complained\":[],\"processed\":[]}}",true,(c,h)->{
      var r=new MetricsApi(c).getPerformanceMetrics("fixture-key","2026-10-01T00:00:00Z","2026-10-02T00:00:00Z","fixture+campaign","day"); require(r.getBounced()==2 && r.getBuckets()!=null,"metric value/buckets"); checkBuckets(c.getObjectMapper().readTree(c.getObjectMapper().writeValueAsString(r)).get("buckets"), c.getObjectMapper().readTree("{\"delivered\":10,\"bounced\":2,\"complained\":1,\"processed\":12,\"buckets\":{\"delivered\":[],\"bounced\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":2}],\"complained\":[],\"processed\":[]}}").get("buckets")); require(h.query().equals(Map.of("start_time","2026-10-01T00:00:00Z","end_time","2026-10-02T00:00:00Z","campaign_id","fixture+campaign","interval","day")),"metric filters");
    });
    ContractFixture.run("GET","/metrics/recipient-behaviour",200,"{\"unsubscribed\":2,\"unsubscribe_delivered\":10,\"buckets\":{\"unsubscribed\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":2}],\"unsubscribe_delivered\":[]}}",true,(c,h)->{
      var r=new MetricsApi(c).getRecipientBehaviourMetrics("fixture-key","2026-10-01T00:00:00Z","2026-10-02T00:00:00Z","fixture+campaign","day"); require(r.getUnsubscribed()==2 && r.getBuckets()!=null,"metric value/buckets"); checkBuckets(c.getObjectMapper().readTree(c.getObjectMapper().writeValueAsString(r)).get("buckets"), c.getObjectMapper().readTree("{\"unsubscribed\":2,\"unsubscribe_delivered\":10,\"buckets\":{\"unsubscribed\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":2}],\"unsubscribe_delivered\":[]}}").get("buckets")); require(h.query().equals(Map.of("start_time","2026-10-01T00:00:00Z","end_time","2026-10-02T00:00:00Z","campaign_id","fixture+campaign","interval","day")),"metric filters");
    });
    ContractFixture.run("GET","/metrics/volume",200,"{\"processed\":12,\"delivered\":10,\"dropped\":2,\"buckets\":{\"processed\":[],\"delivered\":[],\"dropped\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":2}]}}",true,(c,h)->{
      var r=new MetricsApi(c).getVolumeMetrics("fixture-key","2026-10-01T00:00:00Z","2026-10-02T00:00:00Z","fixture+campaign","day"); require(r.getDropped()==2 && r.getBuckets()!=null,"metric value/buckets"); checkBuckets(c.getObjectMapper().readTree(c.getObjectMapper().writeValueAsString(r)).get("buckets"), c.getObjectMapper().readTree("{\"processed\":12,\"delivered\":10,\"dropped\":2,\"buckets\":{\"processed\":[],\"delivered\":[],\"dropped\":[{\"period_start\":\"2026-10-01T00:00:00Z\",\"count\":2}]}}").get("buckets")); require(h.query().equals(Map.of("start_time","2026-10-01T00:00:00Z","end_time","2026-10-02T00:00:00Z","campaign_id","fixture+campaign","interval","day")),"metric filters");
    });
    ContractFixture.run("GET","/metrics/senders/campaigns",200,"{\"limit\":5,\"offset\":10,\"total\":20,\"senders\":[{\"name\":\"fixture-campaign\",\"processed\":10,\"delivered\":8,\"bounced\":1,\"dropped\":1}]}",true,(c,h)->{
      var r=new MetricsApi(c).getSenderMetrics("campaigns","fixture-key",null,null,5,10,"desc"); require(r.getTotal()==20 && r.getSenders().get(0).getDelivered()==8 && h.query().equals(Map.of("limit","5","offset","10","sort_order","desc")),"sender metrics");
    });
    ContractFixture.run("GET","/usage",200,"{\"monthly_limit\":0,\"total_usage\":4294967296,\"period_start_date\":\"2026-10-01\",\"period_end_date\":\"2026-10-31\"}",true,(c,h)->{
      var r=new UsageApi(c).getUsage("fixture-key"); require(r.getMonthlyLimit()==0 && r.getTotalUsage()==4294967296L && r.getPeriodStartDate().equals(java.time.LocalDate.of(2026,10,1)),"parent usage");
    });
    ContractFixture.run("GET","/sub-account/team%2Fa%20b%2B%3F%23/limit",200,"{\"sends\":-1}",true,(c,h)->{
      require(new SubAccountsApi(c).getSubaccountLimit("team/a b+?#","fixture-key").getSends()==-1,"inherited limit");
    });
    ContractFixture.run("PUT","/sub-account/fixture/limit",200,"{\"limit\":{\"sends\":0}}",true,(c,h)->{
      var r=new SubAccountsApi(c).setSubaccountLimit("fixture","fixture-key",new LimitInput().sends(0)); require(r.getLimit().getSends()==0,"zero limit"); require(c.getObjectMapper().readTree(h.body).equals(c.getObjectMapper().readTree("{\"sends\":0}")),"request body");
    });
    ContractFixture.run("DELETE","/sub-account/fixture/limit",204,"",true,(c,h)->{
      require(new SubAccountsApi(c).deleteSubaccountLimitWithHttpInfo("fixture","fixture-key").getStatusCode()==204 && h.body.isEmpty(),"delete limit");
    });
    ContractFixture.run("POST","/sub-account/fixture/api-key",201,"{\"id\":41,\"key\":\"fixture-created-secret\"}",true,(c,h)->{
      var r=new SubAccountsApi(c).createSubaccountApiKey("fixture","fixture-key"); require(r.getId()==41 && r.getKey().equals("fixture-created-secret") && !r.toString().contains("fixture-created-secret"),"API key");
    });
    ContractFixture.run("GET","/sub-account/fixture/api-key",200,"[{\"id\":41}]",true,(c,h)->{
      var r=new SubAccountsApi(c).listSubaccountApiKeys("fixture","fixture-key",10,20); require(r.size()==1 && r.get(0).getId()==41 && r.get(0).getKey()==null && h.query().equals(Map.of("limit","10","offset","20")),"key list");
    });
    ContractFixture.run("DELETE","/sub-account/fixture/api-key/41",204,"",true,(c,h)->{
      require(new SubAccountsApi(c).deleteSubaccountApiKeyWithHttpInfo("fixture",41,"fixture-key").getStatusCode()==204,"delete key");
    });
    ContractFixture.run("POST","/sub-account",201,"{\"handle\":\"fixture\",\"enabled\":true,\"company_name\":\"Fixture Company\"}",true,(c,h)->{
      var r=new SubAccountsApi(c).createSubaccount("fixture-key",new SubAccountData().companyName("Fixture Company").handle("fixture")); require(r.getHandle().equals("fixture") && r.getEnabled(),"create account"); require(c.getObjectMapper().readTree(h.body).equals(c.getObjectMapper().readTree("{\"company_name\":\"Fixture Company\",\"handle\":\"fixture\"}")),"request body");
    });
    ContractFixture.run("POST","/sub-account",201,"{\"handle\":\"generated\",\"enabled\":true}",true,(c,h)->{
      var r=new SubAccountsApi(c).createSubaccount("fixture-key",null); require(r.getHandle().equals("generated") && h.body.isEmpty() && h.contentType==null,"omitted account body");
    });
    ContractFixture.run("GET","/sub-account",200,"[{\"handle\":\"fixture\",\"enabled\":false}]",true,(c,h)->{
      var r=new SubAccountsApi(c).listSubaccounts("fixture-key",5,10); require(r.size()==1 && !r.get(0).getEnabled() && h.query().equals(Map.of("limit","5","offset","10")),"account list");
    });
    ContractFixture.run("POST","/sub-account/fixture/activate",204,"",true,(c,h)->{
      require(new SubAccountsApi(c).activateSubaccountWithHttpInfo("fixture","fixture-key").getStatusCode()==204,"account lifecycle");
    });
    ContractFixture.run("POST","/sub-account/fixture/suspend",204,"",true,(c,h)->{
      require(new SubAccountsApi(c).suspendSubaccountWithHttpInfo("fixture","fixture-key").getStatusCode()==204,"account lifecycle");
    });
    ContractFixture.run("DELETE","/sub-account/fixture",204,"",true,(c,h)->{
      require(new SubAccountsApi(c).deleteSubaccountWithHttpInfo("fixture","fixture-key").getStatusCode()==204,"account lifecycle");
    });
    ContractFixture.run("GET","/sub-account/fixture/usage",200,"{\"monthly_limit\":0,\"total_usage\":4294967296,\"period_start_date\":\"2026-10-01\",\"period_end_date\":\"2026-10-31\"}",true,(c,h)->{
      var r=new SubAccountsApi(c).getSubaccountUsage("fixture","fixture-key"); require(r.getTotalUsage()==4294967296L && r.getPeriodEndDate().equals(java.time.LocalDate.of(2026,10,31)),"account usage");
    });
    ContractFixture.run("POST","/sub-account/fixture/smtp-password",201,"{\"id\":12,\"enabled\":true,\"smtp_password\":\"fixture-smtp-secret\"}",true,(c,h)->{
      var r=new SubAccountsApi(c).createSubaccountSmtpPassword("fixture","fixture-key"); require(r.getId()==12 && r.getEnabled() && r.getSmtpPassword().equals("fixture-smtp-secret") && !r.toString().contains("fixture-smtp-secret"),"SMTP password");
    });
    ContractFixture.run("GET","/sub-account/fixture/smtp-password",200,"[{\"id\":12,\"enabled\":false}]",true,(c,h)->{
      var r=new SubAccountsApi(c).listSubaccountSmtpPasswords("fixture","fixture-key"); require(r.size()==1 && !r.get(0).getEnabled() && r.get(0).getSmtpPassword()==null,"SMTP list");
    });
    ContractFixture.run("DELETE","/sub-account/fixture/smtp-password/12",204,"",true,(c,h)->{
      require(new SubAccountsApi(c).deleteSubaccountSmtpPasswordWithHttpInfo("fixture",12,"fixture-key").getStatusCode()==204,"SMTP delete");
    });
    ContractFixture.run("POST","/webhook/validate",200,"{\"all_passed\":false,\"results\":[]}",true,(c,h)->{
      var r=new WebhooksApi(c).validateWebhook("fixture-key",null);
      require(!r.getAllPassed() && h.body.isEmpty() && h.contentType==null,"omitted webhook validation body");
    });
    System.out.println("Java management contract checks passed: " + ContractFixture.passed);
  }
}
