package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestStringChainTests {
    @Test
    public void test() {
        LongestStringChain ls = new LongestStringChain();

        String[] words = {"a","b","ba","bca","bda","bdca"};

        Assertions.assertThat(ls.longestStrChain(words)).isEqualTo(4);
    }
}
