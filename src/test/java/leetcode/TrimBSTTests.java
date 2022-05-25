package leetcode;

import leetcode.treeNodeExercises.TreeNode;
import leetcode.treeNodeExercises.TrimBST;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TrimBSTTests {
    @Test
    public void trim_bst() {
        TrimBST tb = new TrimBST();
        TreeNode n1 = new TreeNode(1);
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);

        n1.left = n0;
        n1.right = n2;

        TreeNode n11 = new TreeNode(1);
        TreeNode n22 = new TreeNode(2);

        n11.right = n22;

        Assertions.assertThat(tb.trimBST(n1, 1, 2).toString()).isEqualTo(n11.toString());
    }
}
