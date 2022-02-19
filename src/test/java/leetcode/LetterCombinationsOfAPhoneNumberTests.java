package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class LetterCombinationsOfAPhoneNumberTests {
    @Test
    public void letter_combinations() {
        LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();

        List<String> expected = List.of("ad","ae","af","bd","be","bf","cd","ce","cf");

        Assertions.assertThat(lc.letterCombinations("23")).isEqualTo(expected);
    }
}
