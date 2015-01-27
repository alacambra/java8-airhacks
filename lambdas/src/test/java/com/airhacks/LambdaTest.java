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
        f.fly(42);
    }

    @Test
    public void handles() {
        Flyable f = this::something;
        f.fly(2);

        Flyable another = LambdaTest::somethingStatic;
        another.fly(3);
    }

    public void something(int speed) {
        LogProvider.get().accept("logging: " + speed);
    }

    public static void somethingStatic(int speed) {
        System.out.println("handle speed : " + speed);
    }

}
