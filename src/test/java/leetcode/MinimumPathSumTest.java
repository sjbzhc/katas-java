package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumPathSumTest {
    @Test
    void test() {
        MinimumPathSum mp = new MinimumPathSum();

        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};

        Assertions.assertThat(mp.minPathSum(grid)).isEqualTo(7);
    }
}
