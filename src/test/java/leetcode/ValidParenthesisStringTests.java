package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ValidParenthesisStringTests {
    @Test
    public void test() {
        ValidParenthesisString vp = new ValidParenthesisString();

        Assertions.assertThat(vp.checkValidString("(*)")).isTrue();
    }
}
