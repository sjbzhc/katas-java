package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class InterleavingStringTests {
    @Test
    public void test() {
        InterleavingString is = new InterleavingString();

        Assertions.assertThat(is.isInterleave("aabcc", "dbbca", "aadbbcbcac")).isTrue();
    }
}
