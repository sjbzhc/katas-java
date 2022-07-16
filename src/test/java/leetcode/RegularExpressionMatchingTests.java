package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RegularExpressionMatchingTests {
    @Test
    public void test() {
        RegularExpressionMatching re = new RegularExpressionMatching();

        Assertions.assertThat(re.isMatch("aa", "a")).isFalse();
    }
}
