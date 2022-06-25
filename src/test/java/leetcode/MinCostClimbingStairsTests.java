package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinCostClimbingStairsTests {
    @Test
    public void mid_cost_climbing() {
        MinCostClimbingStairs mc = new MinCostClimbingStairs();
        int[] nums = {10, 15, 20};

        Assertions.assertThat(mc.minCostClimbingStairs(nums)).isEqualTo(15);
        Assertions.assertThat(mc.minCostClimbingStairsBottomUp(nums)).isEqualTo(15);
    }
}
