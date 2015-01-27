package com.airhacks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class CompletableFutureTest {

    @Test
    public void producerConsumer() {
        ExecutorService tp = Executors.newFixedThreadPool(2);
        CompletableFuture.supplyAsync(MessageProducer::getMessage, tp).
                thenAccept(MessageConsumer::consume).
                exceptionally((Throwable t) -> {
                    CompletableFutureTest.handle(t);
                    return null;
                });

    }

    public static void handle(Throwable ex) {
        System.out.println("Exception happened: " + ex);
    }

    @Test
    public void orchestration() throws TimeoutException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CompletableFuture<String> first = CompletableFuture.supplyAsync(MessageProducer::getMessage);
        CompletableFuture<String> second = CompletableFuture.supplyAsync(SlowMessageProducer::getMessageSlowly);
        CompletableFuture<Void> result = CompletableFuture.anyOf(first, second).
                thenAccept(r -> System.out.println(r));

    }

}
