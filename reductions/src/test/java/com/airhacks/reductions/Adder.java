package com.airhacks.reductions;

import java.util.function.IntConsumer;

/**
 *
 * @author airhacks.com
 */
public class Adder implements IntConsumer {

    private int sum;

    public Adder() {
        System.out.println("Adder::new");
    }

    @Override
    public void accept(int value) {
        System.out.println("Adder::accept(" + value + ");");
        this.sum += value;
    }

    public int getSum() {
        return sum;
    }

    public void combine(Adder adder) {
        System.out.println("Adder::combine(" + adder.sum + ")");
        this.sum += adder.sum;
    }

}
