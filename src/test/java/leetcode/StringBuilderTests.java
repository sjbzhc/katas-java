package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class StringBuilderTests {
    @Test
    public void test() {
        StringBuilder sb = new StringBuilder("abcd");

        sb.deleteCharAt(1);

        Assertions.assertThat(sb.toString()).isEqualTo("acd");

        sb.insert(1, 'b');

        Assertions.assertThat(sb.toString()).isEqualTo("abcd");
    }
}
