package com.mailchannels.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/** Typed success response selected by HTTP status, not JSON shape. */
public final class CreateTrackingResult {
  private final int statusCode;
  private final CustomTrackingDomain primary;
  private final DnsSetupRequired accepted;
  private final JsonNode unknown;
  private CreateTrackingResult(int statusCode, CustomTrackingDomain primary, DnsSetupRequired accepted, JsonNode unknown) {
    this.statusCode = statusCode; this.primary = primary; this.accepted = accepted; this.unknown = unknown;
  }
  public int getStatusCode() { return statusCode; }
  public CustomTrackingDomain getCreated() { return primary; }
  public DnsSetupRequired getAccepted() { return accepted; }
  /** Explicit, unredacted data for an undocumented success status. */
  public JsonNode getUnknown() { return unknown; }
  public static CreateTrackingResult decode(int status, String body, ObjectMapper mapper) throws IOException {
    if (body.isEmpty()) return new CreateTrackingResult(status, null, null, null);
    if (status == 201) return new CreateTrackingResult(status, mapper.readValue(body, CustomTrackingDomain.class), null, null);
    if (status == 202) return new CreateTrackingResult(status, null, mapper.readValue(body, DnsSetupRequired.class), null);
    return new CreateTrackingResult(status, null, null, mapper.readTree(body));
  }
  @Override public String toString() { return "CreateTrackingResult { [REDACTED] }"; }
}
