package com.mailchannels.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/** Buffer the complete response within the request deadline, including body receipt. */
public final class BoundedHttpTransport {
  private BoundedHttpTransport() {}

  public static HttpResponse<InputStream> send(HttpClient client, HttpRequest request)
      throws IOException, InterruptedException {
    if (Thread.interrupted()) {
      throw new InterruptedException("MailChannels request cancelled before dispatch");
    }
    AtomicBoolean cancelled = new AtomicBoolean();
    AtomicReference<Flow.Subscription> subscription = new AtomicReference<>();
    HttpResponse.BodyHandler<InputStream> handler = info -> new HttpResponse.BodySubscriber<InputStream>() {
      private final HttpResponse.BodySubscriber<InputStream> delegate = HttpResponse.BodySubscribers.mapping(
          HttpResponse.BodySubscribers.ofByteArray(), bytes -> new ByteArrayInputStream(bytes));
      public CompletionStage<InputStream> getBody() { return delegate.getBody(); }
      public void onSubscribe(Flow.Subscription value) {
        subscription.set(value);
        if (cancelled.get()) value.cancel();
        else delegate.onSubscribe(value);
      }
      public void onNext(List<ByteBuffer> bytes) { delegate.onNext(bytes); }
      public void onError(Throwable error) { delegate.onError(error); }
      public void onComplete() { delegate.onComplete(); }
    };
    var pending = client.sendAsync(request, handler);
    try {
      return request.timeout().isPresent()
          ? pending.get(request.timeout().get().toNanos(), TimeUnit.NANOSECONDS)
          : pending.get();
    } catch (TimeoutException e) {
      cancelled.set(true);
      Flow.Subscription active = subscription.get();
      if (active != null) active.cancel();
      pending.cancel(true);
      throw new HttpTimeoutException("MailChannels response deadline exceeded");
    } catch (InterruptedException e) {
      cancelled.set(true);
      Flow.Subscription active = subscription.get();
      if (active != null) active.cancel();
      pending.cancel(true);
      throw e;
    } catch (ExecutionException e) {
      Throwable cause = e.getCause();
      if (cause instanceof IOException) throw (IOException) cause;
      if (cause instanceof RuntimeException) throw (RuntimeException) cause;
      if (cause instanceof Error) throw (Error) cause;
      throw new IOException("MailChannels transport failed", cause);
    }
  }
}
