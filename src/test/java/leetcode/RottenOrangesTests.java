package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RottenOrangesTests {
    @Test
    public void rotten_oranges() {
        RottenOranges ro = new RottenOranges();
        int[] r1 = {2,1,1};
        int[] r2 = {1,1,0};
        int[] r3 = {0,1,1};

        int[][] grid = {r1,r2,r3};

        Assertions.assertThat(ro.orangesRotting(grid)).isEqualTo(4);
    }

    @Test
    public void rotten_oranges_2() {
        RottenOranges2 ro = new RottenOranges2();
        int[] r1 = {2,1,1};
        int[] r2 = {1,1,0};
        int[] r3 = {0,1,1};

        int[][] grid = {r1,r2,r3};

        Assertions.assertThat(ro.orangesRotting(grid)).isEqualTo(4);
    }

    @Test
    public void rotten_oranges_2_2() {
        RottenOranges2 ro = new RottenOranges2();
        int[] r1 = {2,1,1};
        int[] r2 = {0,1,1};
        int[] r3 = {1,0,1};

        int[][] grid = {r1,r2,r3};

        Assertions.assertThat(ro.orangesRotting(grid)).isEqualTo(-1);
    }

    @Test
    public void rotten_oranges_2_0() {
        RottenOranges2 ro = new RottenOranges2();
        int[] r1 = {0,2};

        int[][] grid = {r1};

        Assertions.assertThat(ro.orangesRotting(grid)).isEqualTo(0);
    }

    @Test
    public void rotten_oranges_2_1() {
        RottenOranges2 ro = new RottenOranges2();
        int[] r1 = {0,1};

        int[][] grid = {r1};

        Assertions.assertThat(ro.orangesRotting(grid)).isEqualTo(-1);
    }

    @Test
    public void rotten_oranges_2_2_() {
        RottenOranges2 ro = new RottenOranges2();
        int[] r1 = {2,1,1};
        int[] r2 = {1,1,1};
        int[] r3 = {0,1,2};

        int[][] grid = {r1,r2,r3};

        Assertions.assertThat(ro.orangesRotting(grid)).isEqualTo(2);
    }
}
