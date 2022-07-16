package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SwimInWaterTests {
    @Test
    public void test() {
        SwimInWater sw = new SwimInWater();
        int[][] grid = {{0, 2}, {1, 3}};

        Assertions.assertThat(sw.swimInWater(grid)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        SwimInWater sw = new SwimInWater();
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};

        Assertions.assertThat(sw.swimInWater(grid)).isEqualTo(16);
    }
}
