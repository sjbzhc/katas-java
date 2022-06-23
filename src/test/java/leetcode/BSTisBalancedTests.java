package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BSTisBalancedTests {
    @Test
    public void bst_is_balanced() {
        BSTisBalanced bsTisBalanced = new BSTisBalanced();
        TreeNode tn = new TreeNode(1);
        TreeNode tnn = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);

        tn.left = tn2;
        tn.right = tn3;

        tn4.left = tn5;
        tn5.left = tn6;
        tn6.left = tn7;
        tnn.left = tn4;

        Assertions.assertThat(bsTisBalanced.isBalanced(tn)).isTrue();
        Assertions.assertThat(bsTisBalanced.isBalanced(tnn)).isFalse();

    }
}
