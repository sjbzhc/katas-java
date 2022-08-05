package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumNumberOfMovesToMakePalindromeTests {
    @Test
    public void test() {
        MinimumNumberOfMovesToMakePalindrome mn = new MinimumNumberOfMovesToMakePalindrome();

        Assertions.assertThat(mn.minMovesToMakePalindrome("aabb")).isEqualTo(2);
    }
}
