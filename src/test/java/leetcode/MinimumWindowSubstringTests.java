package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumWindowSubstringTests {
    @Test
    public void test() {
        MinimumWindowSubstring mw = new MinimumWindowSubstring();

        Assertions.assertThat(mw.minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
    }
}
