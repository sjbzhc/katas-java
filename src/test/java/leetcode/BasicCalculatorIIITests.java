package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BasicCalculatorIIITests {
    @Test
    public void test() {
        BasicCalculatorIII bc = new BasicCalculatorIII();

        Assertions.assertThat(bc.calculate("6-4/2")).isEqualTo(4);
    }
}
