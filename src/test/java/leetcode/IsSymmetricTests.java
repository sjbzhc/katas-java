package leetcode;

import leetcode.treeNodeExercises.IsSymmetric;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class IsSymmetricTests {
    @Test
    public void is_symmetric() {
        IsSymmetric is = new IsSymmetric();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n2_2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n3_2 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n4_2 = new TreeNode(4);
        n2.left = n3;
        n2.right = n4;
        n2_2.left = n4_2;
        n2_2.right = n3_2;
        n1.left = n2;
        n1.right = n2_2;

        Assertions.assertThat(is.isSymmetric(n1)).isTrue();
    }
}
