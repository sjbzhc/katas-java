package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumIntervalToIncludeTests {
    @Test
    public void test() {
        MinimumIntervalToInclude mv = new MinimumIntervalToInclude();
        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
        int[] queries = {2,3,4,5};
        int[] output = {3,3,1,4};

        Assertions.assertThat(mv.minInterval(intervals, queries)).isEqualTo(output);

    }
}
