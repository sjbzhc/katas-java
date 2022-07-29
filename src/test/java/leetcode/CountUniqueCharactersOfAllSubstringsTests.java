package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CountUniqueCharactersOfAllSubstringsTests {
    @Test
    public void test() {
        CountUniqueCharactersOfAllSubstrings cu = new CountUniqueCharactersOfAllSubstrings();

        Assertions.assertThat(cu.uniqueLetterString("ABC")).isEqualTo(10);
    }
}
