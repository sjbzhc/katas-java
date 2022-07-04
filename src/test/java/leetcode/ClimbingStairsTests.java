package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/*
*
* We build a binary tree, where we branch with either 1-step or 2-step. We look for the paths
* that add up to n
*
* Avoid repeating by memoization or bottom-up DP
*
* Time: O(n)
* Space: O(1)
* */

public class ClimbingStairsTests {
    @Test
    public void climbing_stairs() {
        ClimbingStairs cs = new ClimbingStairs();

        Assertions.assertThat(cs.climbStairs(3)).isEqualTo(3);
        Assertions.assertThat(cs.climbStairsDP(3)).isEqualTo(3);
    }

    @Test
    public void climbing_stairs_5() {
        ClimbingStairs cs = new ClimbingStairs();

        Assertions.assertThat(cs.climbStairs(5)).isEqualTo(8);
        Assertions.assertThat(cs.climbStairsDP(5)).isEqualTo(8);
    }
}
