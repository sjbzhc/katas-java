package leetcode;

import leetcode.expressionTree.Node;
import leetcode.expressionTree.Node2;
import leetcode.expressionTree.TreeBuilder;
import leetcode.expressionTree.TreeBuilder2;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ExpressionBuilderTests {
    @Test
    public void expression_tree() {
        TreeBuilder et = new TreeBuilder();
        String[] postfix = new String[]{"3","4","+","2","*","7","/"};
        Node node = et.buildTree(postfix);
        Assertions.assertThat(node.evaluate()).isEqualTo(2);
    }

    @Test
    public void expression_tree_2() {
        TreeBuilder et = new TreeBuilder();
        String[] postfix = new String[]{"4", "5", "2", "7", "+", "-", "*"};
        Node node = et.buildTree(postfix);
        Assertions.assertThat(node.evaluate()).isEqualTo(-16);
    }

    @Test
    public void expression_tree_2_1() {
        TreeBuilder2 et = new TreeBuilder2();
        String[] postfix = new String[]{"3","4","+","2","*","7","/"};
        Node2 node = et.buildTree(postfix);
        Assertions.assertThat(node.evaluate()).isEqualTo(2);
    }
}
