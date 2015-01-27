package com.airhacks;

import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class LambdaTest {

    @Test
    public void runnable() {
        Runnable run = () -> System.out.println("Works!");

        Thread t = new Thread(run);
        t.start();
    }

    @Test
    public void plane() {
        Flyable f = (int s) -> System.out.println("flying " + s);
    }

}
