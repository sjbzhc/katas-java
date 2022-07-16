package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestIncreasingPathTests {
    @Test
    public void test() {
        LongestIncreasingPath li = new LongestIncreasingPath();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};

        Assertions.assertThat(li.longestIncreasingPath(matrix)).isEqualTo(4);
    }
}
