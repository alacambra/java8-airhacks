package com.airhacks;

/**
 *
 * @author airhacks.com
 */
@FunctionalInterface
public interface Flyable {

    void fly(int speed);

    default void fall(int speed) {
        fly(-speed);
    }
}
