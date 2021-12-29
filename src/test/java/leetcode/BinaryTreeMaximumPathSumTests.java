package leetcode;

import leetcode.validateBinarySearchTree.BinaryTreeMaximumPathSum;
import leetcode.validateBinarySearchTree.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BinaryTreeMaximumPathSumTests {
    @Test
    public void binary_tree_max_path_sum() {
        BinaryTreeMaximumPathSum bt = new BinaryTreeMaximumPathSum();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        Assertions.assertThat(bt.maxPathSum(n1)).isEqualTo(6);
    }
}
