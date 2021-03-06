package com.airhacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class CollectionTest {

    @Test
    public void findCoolProgrammers() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("duke", "java", 5));
        developers.add(new Developer("larry", "go", 2));
        developers.add(new Developer("brandon", "javascript", 5));

        List<Developer> jDevelopers = developers.stream().
                filter((t) -> t.getLanguage().startsWith("j")).
                collect(Collectors.toList());

        assertThat(jDevelopers.size(), is(2));
        final Predicate<? super Developer> name
                = (d) -> d.getLanguage().startsWith("j");

        double averageAge = developers.parallelStream().
                filter(name).
                mapToInt((d) -> d.getAge()).
                average().orElse(0);

        System.out.println("averageAge = " + averageAge);

        Map<Integer, List<Developer>> collect = developers.
                stream().
                collect(Collectors.groupingBy((t) -> t.getAge()));
        System.out.println("collect = " + collect);

    }

}
