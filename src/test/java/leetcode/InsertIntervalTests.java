package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class InsertIntervalTests {
    @Test
    public void test() {
        InsertInterval ii = new InsertInterval();

        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        int[][] output = {{1,5},{6,9}};

        Assertions.assertThat(ii.insert(intervals, newInterval)).isEqualTo(output);
    }
}
