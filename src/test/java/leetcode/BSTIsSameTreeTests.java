package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BSTIsSameTreeTests {
    @Test
    public void is_same_tree() {
        BSTIsSameTree bstIsSameTree = new BSTIsSameTree();

        TreeNode tn = new TreeNode(1);
        TreeNode tnn = new TreeNode(1);

        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        tn.left = tn2;
        tn.right = tn3;

        tnn.left = tn2;
        tnn.right = tn3;

        Assertions.assertThat(bstIsSameTree.isSameTree(tn, tnn)).isTrue();
    }

    @Test
    public void is_not_same_tree() {
        BSTIsSameTree bstIsSameTree = new BSTIsSameTree();

        TreeNode tn = new TreeNode(1);
        TreeNode tnn = new TreeNode(1);

        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        tn.left = tn2;
        tn.right = tn3;

        tnn.left = tn3;
        tnn.right = tn2;

        Assertions.assertThat(bstIsSameTree.isSameTree(tn, tnn)).isFalse();
    }
}
