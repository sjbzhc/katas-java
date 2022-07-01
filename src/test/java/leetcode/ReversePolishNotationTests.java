package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ReversePolishNotationTests {
    @Test
    public void test() {
        ReversePolishNotation rp = new ReversePolishNotation();
        String[] tokens = {"2","1","+","3","*"};
        Assertions.assertThat(rp.evalRPN(tokens)).isEqualTo(9);
    }
}
