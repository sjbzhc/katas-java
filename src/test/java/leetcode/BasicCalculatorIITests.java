package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BasicCalculatorIITests {

    @Test
    public void test() {
        BasicCalculatorII bc = new BasicCalculatorII();

        Assertions.assertThat(bc.calculate(" 3+5 / 2 ")).isEqualTo(5);
    }
}
