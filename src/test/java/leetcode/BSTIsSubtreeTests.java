package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BSTIsSubtreeTests {

    @Test
    public void is_subtree() {
        BSTIsSubtree bstIsSubtree = new BSTIsSubtree();

        TreeNode tn0 = new TreeNode(0);
        TreeNode tn = new TreeNode(1);
        TreeNode tnn = new TreeNode(1);

        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        tn.left = tn2;
        tn.right = tn3;

        tnn.left = tn2;
        tnn.right = tn3;

        tn0.left = tn;

        Assertions.assertThat(bstIsSubtree.isSubtree(tn0, tnn)).isTrue();
    }
}
