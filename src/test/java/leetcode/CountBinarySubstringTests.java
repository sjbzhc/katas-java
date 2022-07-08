package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CountBinarySubstringTests {

    @Test
    public void count_binary() {
        Assertions.assertThat(CountBinarySubstring.countBinarySubstrings("0011")).isEqualTo(2);
    }

    @Test
    public void count_binary2_create_sequence() {
        int[] arr = {2,2,0,0};
        Assertions.assertThat(CountBinarySubstring2.createSequences("0011")).isEqualTo(arr);
    }

    @Test
    public void count_binary2() {
        Assertions.assertThat(CountBinarySubstring2.countBinarySubstrings("0011")).isEqualTo(2);
        Assertions.assertThat(CountBinarySubstring2.countBinarySubstrings("00111000110000011")).isEqualTo(11);
    }
}
