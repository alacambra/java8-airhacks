package com.airhacks.statistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class IntegerStatisticsTest {

    @Test
    public void statistics() {
        List<Integer> ints = Arrays.asList(new Integer[]{1, 2, 3});
        IntSummaryStatistics result = ints.stream().
                collect(IntSummaryStatistics::new,
                        IntSummaryStatistics::accept,
                        IntSummaryStatistics::combine);
        long count = result.getCount();
        int max = result.getMax();
        int min = result.getMin();
        long sum = result.getSum();
        System.out.println("sum = " + sum + "min= " + min + "max" + max + "count=" + count);
    }

}
