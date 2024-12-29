package leetcode;

import leetcode.rpn.Addition;
import leetcode.rpn.RPNCalculator;
import leetcode.rpn.Sqrt;
import leetcode.rpn.Subtraction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class RPNCalculatorTest {
    @Test
    void addition() {
        RPNCalculator calc = new RPNCalculator(List.of(new Addition("+")));

        Assertions.assertThat(calc.calculate("3 4 +")).isEqualTo(7.0);
    }

    @Test
    void subtraction() {
        RPNCalculator calc = new RPNCalculator(List.of(new Addition("+"), new Subtraction("-")));

        Assertions.assertThat(calc.calculate("3 4 -")).isEqualTo(-1.0);
    }

    @Test
    void sqrt() {
        RPNCalculator calc = new RPNCalculator(List.of(new Addition("+"), new Subtraction("-"), new Sqrt("sqrt")));

        Assertions.assertThat(calc.calculate("16 sqrt")).isEqualTo(4);
    }

    @Test
    void sqrt_of_sum() {
        RPNCalculator calc = new RPNCalculator(List.of(new Addition("+"), new Subtraction("-"), new Sqrt("sqrt")));

        Assertions.assertThat(calc.calculate("8 8 + sqrt")).isEqualTo(4);
    }
}
