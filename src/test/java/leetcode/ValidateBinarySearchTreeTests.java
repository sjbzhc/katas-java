package leetcode;

import leetcode.validateBinarySearchTree.TreeNode;
import leetcode.validateBinarySearchTree.ValidateBinarySearchTree;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ValidateBinarySearchTreeTests {
    @Test
    public void validate_binary_search_tree() {
        ValidateBinarySearchTree vb = new ValidateBinarySearchTree();
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(3);

        tn2.left = tn1;
        tn2.right = tn3;

        Assertions.assertThat(vb.isValidBST(tn2)).isTrue();
    }
}
