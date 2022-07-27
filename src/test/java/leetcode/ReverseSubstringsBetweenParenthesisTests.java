package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ReverseSubstringsBetweenParenthesisTests {
    @Test
    public void test() {
        ReverseSubstringsBetweenParenthesis rs = new ReverseSubstringsBetweenParenthesis();

        Assertions.assertThat(rs.reverseParentheses("(u(love)i)")).isEqualTo("iloveu");
    }
}
