package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MultiplyStringsTests {
    @Test
    public void multiply_strings() {
        MultiplyStrings ms = new MultiplyStrings();
        Assertions.assertThat(ms.multiply("123", "456")).isEqualTo("56088");
    }
}
