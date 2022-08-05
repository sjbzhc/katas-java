package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestContinuousSubarrayTests {
    @Test
    public void test() {
        LongestContinuousSubarray lc = new LongestContinuousSubarray();

        int[] nums = {8,2,4,7};

        Assertions.assertThat(lc.longestSubarray(nums, 4)).isEqualTo(2);
    }
}
