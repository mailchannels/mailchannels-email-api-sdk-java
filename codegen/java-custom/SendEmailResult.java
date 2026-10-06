package com.mailchannels.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/** Typed success response selected by HTTP status, not JSON shape. */
public final class SendEmailResult {
  private final int statusCode;
  private final Message primary;
  private final SendResults accepted;
  private final JsonNode unknown;
  private SendEmailResult(int statusCode, Message primary, SendResults accepted, JsonNode unknown) {
    this.statusCode = statusCode; this.primary = primary; this.accepted = accepted; this.unknown = unknown;
  }
  public int getStatusCode() { return statusCode; }
  public Message getDryRun() { return primary; }
  public SendResults getAccepted() { return accepted; }
  /** Explicit, unredacted data for an undocumented success status. */
  public JsonNode getUnknown() { return unknown; }
  public static SendEmailResult decode(int status, String body, ObjectMapper mapper) throws IOException {
    if (body.isEmpty()) return new SendEmailResult(status, null, null, null);
    if (status == 200) return new SendEmailResult(status, mapper.readValue(body, Message.class), null, null);
    if (status == 202) return new SendEmailResult(status, null, mapper.readValue(body, SendResults.class), null);
    return new SendEmailResult(status, null, null, mapper.readTree(body));
  }
  @Override public String toString() { return "SendEmailResult { [REDACTED] }"; }
}
