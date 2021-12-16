package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NumberToWordsTests {
    @Test
    public void number_to_words() {
        NumberToWords nt = new NumberToWords();

        Assertions.assertThat(nt.numberToWords(123)).isEqualTo("One Hundred Twenty Three");
    }
}
