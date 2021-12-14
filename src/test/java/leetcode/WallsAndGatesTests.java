package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class WallsAndGatesTests {
    @Test
    public void walls_and_gates() {
        WallsAndGates wg = new WallsAndGates();
        int[] r1 = {2147483647,-1,0,2147483647};
        int[] r2 = {2147483647,2147483647,2147483647,-1};
        int[] r3 = {2147483647,-1,2147483647,-1};
        int[] r4 = {0,-1,2147483647,2147483647};
        int[][] room = {r1,r2,r3,r4};

        int[][] expected = {
                {3,-1,0,1},
                {2,2,1,-1},
                {1,-1,2,-1},
                {0,-1,3,4}
        };

        wg.wallsAndGates(room);

        Assertions.assertThat(room).isEqualTo(expected);
    }

    @Test
    public void walls_and_gates_2() {
        WallsAndGates2 wg = new WallsAndGates2();
        int[] r1 = {2147483647,-1,0,2147483647};
        int[] r2 = {2147483647,2147483647,2147483647,-1};
        int[] r3 = {2147483647,-1,2147483647,-1};
        int[] r4 = {0,-1,2147483647,2147483647};
        int[][] room = {r1,r2,r3,r4};

        int[][] expected = {
                {3,-1,0,1},
                {2,2,1,-1},
                {1,-1,2,-1},
                {0,-1,3,4}
        };

        wg.wallsAndGates(room);

        Assertions.assertThat(room).isEqualTo(expected);
    }
}
