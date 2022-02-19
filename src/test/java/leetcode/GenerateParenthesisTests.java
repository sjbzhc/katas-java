package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class GenerateParenthesisTests {
    @Test
    public void generate_parenthesis() {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> expected = List.of("((()))","(()())","(())()","()(())","()()()");

        Assertions.assertThat(gp.generateParenthesis(3)).isEqualTo(expected);
    }
}
