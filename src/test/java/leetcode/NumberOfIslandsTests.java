package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NumberOfIslandsTests {
    @Test
    public void number_of_islands() {
        NumberOfIslands ni = new NumberOfIslands();

        char[] r1 = {'1','1','1','1','0'};
        char[] r2 = {'1','1','0','1','0'};
        char[] r3 = {'1','1','0','0','0'};
        char[] r4 = {'0','0','0','0','0'};

        char[][] grid = {r1, r2, r3, r4};

        Assertions.assertThat(ni.numIslands(grid)).isEqualTo(1);
    }

    @Test
    public void number_of_islands_3_bfs() {
        NumberOfIslands ni = new NumberOfIslands();

        char[] r1 = {'1','1','0','0','0'};
        char[] r2 = {'1','1','0','0','0'};
        char[] r3 = {'0','0','1','0','0'};
        char[] r4 = {'0','0','0','1','1'};

        char[][] grid = {r1, r2, r3, r4};

        Assertions.assertThat(ni.numIslands(grid)).isEqualTo(3);
    }

    @Test
    public void number_of_islands_3() {
        NumberOfIslands ni = new NumberOfIslands();

        char[] r1 = {'1','1','0','0','0'};
        char[] r2 = {'1','1','0','0','0'};
        char[] r3 = {'0','0','1','0','0'};
        char[] r4 = {'0','0','0','1','1'};

        char[][] grid = {r1, r2, r3, r4};

        Assertions.assertThat(ni.numIslandsBFS(grid)).isEqualTo(3);
    }

    @Test
    public void number_of_islands_2() {
        NumberOfIslands2 ni = new NumberOfIslands2();

        char[] r1 = {'1','1','1','1','0'};
        char[] r2 = {'1','1','0','1','0'};
        char[] r3 = {'1','1','0','0','0'};
        char[] r4 = {'0','0','0','0','0'};

        char[][] grid = {r1, r2, r3, r4};

        Assertions.assertThat(ni.numIslands(grid)).isEqualTo(1);
    }

    @Test
    public void number_of_islands_3_2() {
        NumberOfIslands2 ni = new NumberOfIslands2();

        char[] r1 = {'1','1','0','0','0'};
        char[] r2 = {'1','1','0','0','0'};
        char[] r3 = {'0','0','1','0','0'};
        char[] r4 = {'0','0','0','1','1'};

        char[][] grid = {r1, r2, r3, r4};

        Assertions.assertThat(ni.numIslands(grid)).isEqualTo(3);
    }
}
