package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class LongestSubstringWithoutRepeatingCharactersTests {
    @Test
    public void longest_substring() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertThat(ls.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    public void longest_substring_2() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertThat(ls.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    public void longest_substring_3() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertThat(ls.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    public void longest_substring2_1() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertThat(ls.lengthOfLongestSubstring2("abcabcbb")).isEqualTo(3);
    }

    @Test
    public void longest_substring_2_2() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertThat(ls.lengthOfLongestSubstring2("bbbbb")).isEqualTo(1);
    }

    @Test
    public void longest_substring_2_3() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertThat(ls.lengthOfLongestSubstring2("pwwkew")).isEqualTo(3);
    }

    @Test
    public void longest_substring_2_4() {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        Assertions.assertThat(ls.lengthOfLongestSubstring2("abcabcd")).isEqualTo(4);
    }
}
