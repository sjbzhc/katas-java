package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NonOverlappingIntervalsTests {
    @Test
    public void test() {
        NonOverlappingIntervals no = new NonOverlappingIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        Assertions.assertThat(no.eraseOverlapIntervals(intervals)).isEqualTo(1);
    }
}
