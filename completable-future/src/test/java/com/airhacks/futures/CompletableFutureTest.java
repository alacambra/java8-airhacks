package com.airhacks.futures;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class CompletableFutureTest {

    @Test
    public void chain() throws InterruptedException {
        CompletableFuture.supplyAsync(() -> 1).
                thenApplyAsync((t) -> t * 2).
                thenApplyAsync((t) -> t * 21).
                thenAccept(System.out::println);
    }

    @Test
    public void handle() {
        CompletableFuture.supplyAsync(new Supplier<String>() {

            @Override
            public String get() {
                throw new RuntimeException("Very lazy");
            }
        }).handle((String t, Throwable u) -> "Exception happened" + u).thenAccept(System.out::println);

    }

}
