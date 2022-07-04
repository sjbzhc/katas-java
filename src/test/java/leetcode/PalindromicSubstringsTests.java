package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PalindromicSubstringsTests {
    @Test
    public void test() {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        Assertions.assertThat(ps.countSubstrings("aaa")).isEqualTo(6);
    }
}
