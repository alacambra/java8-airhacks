package com.airhacks;

import java.util.ArrayList;
import java.util.List;
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
        developers.add(new Developer("brandon", "javascript", 6));

        List<Developer> jDevelopers = developers.stream().
                filter((t) -> t.getLanguage().startsWith("j")).
                collect(Collectors.toList());

        assertThat(jDevelopers.size(), is(2));

    }

}
