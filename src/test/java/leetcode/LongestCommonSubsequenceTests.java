package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestCommonSubsequenceTests {
    @Test
    public void test() {
        LongestCommonSubsequence lc = new LongestCommonSubsequence();

        Assertions.assertThat(lc.longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
    }
}
