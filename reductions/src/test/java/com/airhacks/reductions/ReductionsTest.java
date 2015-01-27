package com.airhacks.reductions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ReductionsTest {

    private List<Integer> list;

    @Before
    public void init() {
        this.list = Arrays.asList(1, 2, 3);
    }

    @Test
    public void reduce() {
        Integer sum = list.stream().reduce(0, (a, b) -> (a + b));
        assertThat(sum, is(1 + 2 + 3));

        sum = list.stream().reduce(42, (a, b) -> (a + b));
        assertThat(sum, is(42 + 1 + 2 + 3));
    }

    @Test
    public void customCollector() {
        Adder adder = this.list.stream().collect(Adder::new, Adder::accept, Adder::combine);
        assertThat(adder.getSum(), is(1 + 2 + 3));
    }

    @Test
    public void groupBy() {
        List<Developer> developers = Arrays.asList(
                new Developer("java", 20),
                new Developer("java", 18),
                new Developer("java", 30),
                new Developer("lisp", 50),
                new Developer("lisp", 60),
                new Developer("cobol", 60));
        double averageJavaDeveloperAge = (20 + 18 + 30) / 3d;

        Map<String, List<Developer>> developersByLanguage
                = developers.stream().
                collect(Collectors.groupingBy(Developer::getLanguage));

        final List<Developer> javaDevelopers = developersByLanguage.get("java");
        assertThat(javaDevelopers.size(), is(3));
        assertThat(javaDevelopers.stream().mapToInt(d -> d.getAge()).average().getAsDouble(), is(averageJavaDeveloperAge));

        Map<String, List<Integer>> agesByLanguage = developers.stream().collect(
                Collectors.groupingBy(Developer::getLanguage,
                        Collectors.mapping(Developer::getAge, Collectors.toList())));

        final List<Integer> javaAges = agesByLanguage.get("java");
        assertThat(javaAges.size(), is(3));
        assertThat(javaAges.stream().mapToInt(i -> i).average().getAsDouble(), is(averageJavaDeveloperAge));

        Map<String, Double> averageByLanguage = developers.stream().collect(
                Collectors.groupingBy(Developer::getLanguage,
                        Collectors.averagingInt(Developer::getAge)));

        Double averageJavaAge = averageByLanguage.get("java");
        assertThat(averageJavaAge, is(averageJavaDeveloperAge));

    }

}
