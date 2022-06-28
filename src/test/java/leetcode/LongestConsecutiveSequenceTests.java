package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestConsecutiveSequenceTests {
    @Test
    public void test() {
        LongestConsecutiveSequence lc = new LongestConsecutiveSequence();

        int[] nums = {100,4,200,1,3,2};

        Assertions.assertThat(lc.longestConsecutive(nums)).isEqualTo(4);
    }
}
