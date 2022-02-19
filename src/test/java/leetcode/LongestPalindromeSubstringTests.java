package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestPalindromeSubstringTests {
    @Test
    public void longest_palindrome() {
        LongestPalindromeSubstring lp = new LongestPalindromeSubstring();
        Assertions.assertThat(lp.longestPalindrome("babad")).isEqualTo("bab");
    }
}
