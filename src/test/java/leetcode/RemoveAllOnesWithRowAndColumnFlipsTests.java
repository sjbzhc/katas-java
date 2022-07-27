package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RemoveAllOnesWithRowAndColumnFlipsTests {
    @Test
    public void test() {
        RemoveAllOnesWithRowAndColumnFlips ra = new RemoveAllOnesWithRowAndColumnFlips();

        int[][] grid = {{0,1,0},{1,0,1},{0,1,0}};

        Assertions.assertThat(ra.removeOnes(grid)).isTrue();
    }
}
