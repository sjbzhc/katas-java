package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class InvertBinaryTreeTests {
    @Test
    public void invert_binary_tree() {
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode tn = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        tn.left = tn2;
        tn.right = tn3;

        TreeNode expected = new TreeNode(1);
        expected.left = tn3;
        expected.right = tn2;

        Assertions.assertThat(ibt.invertTree(tn).toString()).isEqualTo(expected.toString());
    }
}
