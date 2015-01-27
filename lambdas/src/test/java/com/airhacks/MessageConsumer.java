package com.airhacks;

/**
 *
 * @author airhacks.com
 */
public class MessageConsumer {

    public static void consume(String message) {
        System.out.println("Thanks for: " + message);
        throw new IllegalStateException("Please stop");
    }
}
