package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaxAreaOfIslandTests {
    @Test
    public void max_area_of_islands() {
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        Assertions.assertThat(ma.maxAreaOfIsland(grid)).isEqualTo(6);
    }

    @Test
    public void max_area_of_islands_4() {
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };

        Assertions.assertThat(ma.maxAreaOfIsland(grid)).isEqualTo(4);
    }
}
