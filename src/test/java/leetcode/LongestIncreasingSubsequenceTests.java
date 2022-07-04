package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestIncreasingSubsequenceTests {
    @Test
    public void test() {
        LongestIncreasingSubsequence li = new LongestIncreasingSubsequence();

        int[] nums = {10,9,2,5,3,7,101,18};

        Assertions.assertThat(li.lengthOfLIS(nums)).isEqualTo(4);
    }
}
