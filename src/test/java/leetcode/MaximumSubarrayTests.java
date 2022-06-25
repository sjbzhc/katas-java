package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaximumSubarrayTests {
    @Test
    public void maximum_subarray() {
        MaximumSubarray ms = new MaximumSubarray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        Assertions.assertThat(ms.maxSubArray(nums)).isEqualTo(6);
        Assertions.assertThat(ms.maxSubArrayGreedy(nums)).isEqualTo(6);
    }
}
