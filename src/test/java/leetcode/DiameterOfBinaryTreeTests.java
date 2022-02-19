package leetcode;

import leetcode.treeNodeExercises.DiameterOfBinaryTree;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class DiameterOfBinaryTreeTests {
    @Test
    public void diameter_binary_tree() {
        DiameterOfBinaryTree db = new DiameterOfBinaryTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n2.left = n4;
        n2.right = n5;
        n1.left = n2;
        n1.right = n3;

        Assertions.assertThat(db.diameterOfBinaryTree(n1)).isEqualTo(3);
    }
}
