package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TargetSumTests {
    @Test
    public void test() {
        TargetSum ts = new TargetSum();

        int[] nums = {1,1,1,1,1};

        Assertions.assertThat(ts.findTargetSumWays(nums, 3)).isEqualTo(5);
    }
}
