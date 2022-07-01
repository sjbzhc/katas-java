package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterReplacementTests {
    @Test
    public void character_replacement() {
        CharacterReplacement cr = new CharacterReplacement();
        Assertions.assertThat(cr.characterReplacement("ABAB", 2)).isEqualTo(4);
    }
}
