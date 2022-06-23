package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ValidPalindromeTest {
    @Test
    public void valid_palindrome() {
        ValidPalindrome vp = new ValidPalindrome();
        Assertions.assertThat(vp.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
    }

    @Test
    public void invalid_palindrome() {
        ValidPalindrome vp = new ValidPalindrome();
        Assertions.assertThat(vp.isPalindrome("race a car")).isFalse();
    }

    @Test
    public void valid_empty_palindrome() {
        ValidPalindrome vp = new ValidPalindrome();
        Assertions.assertThat(vp.isPalindrome(" ")).isTrue();
    }
}
