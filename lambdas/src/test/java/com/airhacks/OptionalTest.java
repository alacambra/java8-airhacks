package com.airhacks;

import java.util.Optional;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class OptionalTest {

    @Test
    public void optional() {
        String message = "42";
        Optional<String> optional = Optional.ofNullable(message);
        optional.ifPresent(this::consume);
        Optional<Integer> value = optional.map((t) -> Integer.parseInt(t));

        Integer result = value.orElse(0);
        assertThat(result, is(0));
    }

    public void consume(String message) {
        System.out.println("Consumed: " + message);
    }
}
