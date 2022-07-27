package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ShortestPathInGridWithObstacleTests {
    @Test
    public void test() {
        ShortestPathInGridWithObstacle sp = new ShortestPathInGridWithObstacle();
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};

        Assertions.assertThat(sp.shortestPath(grid, 1)).isEqualTo(6);
    }
}
