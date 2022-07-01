package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PermutationInStringTests {
    @Test
    public void permutation_in_string() {
        PermutationInString ps = new PermutationInString();

        Assertions.assertThat(ps.checkInclusion("ab", "eidbaooo")).isTrue();
    }
}
