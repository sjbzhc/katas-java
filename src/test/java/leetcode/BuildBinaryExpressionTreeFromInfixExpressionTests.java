package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuildBinaryExpressionTreeFromInfixExpressionTests {
    @Test
    public void test() {
        BuildBinaryExpressionTreeFromInfixExpression bb = new BuildBinaryExpressionTreeFromInfixExpression();

        ExpressionNode en0 = new ExpressionNode('-');
        ExpressionNode en1 = new ExpressionNode('*');
        ExpressionNode en2 = new ExpressionNode('*');
        ExpressionNode en3 = new ExpressionNode('3');
        ExpressionNode en4 = new ExpressionNode('4');
        ExpressionNode en5 = new ExpressionNode('2');
        ExpressionNode en6 = new ExpressionNode('5');

        en1.left = en3;
        en1.right = en4;
        en2.left = en5;
        en2.right = en6;
        en0.left = en1;
        en0.right = en2;

        Assertions.assertThat(bb.expTree("3*4-2*5")).isEqualTo(en0);

    }
}
