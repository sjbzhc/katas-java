package leetcode;

import leetcode.treeNodeExercises.BinaryTreeLevelOrderTraversal;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class BinaryTreeLevelOrderTraversalTests {
    @Test
    public void binary_tree_level_order_traversal() {
        BinaryTreeLevelOrderTraversal btl = new BinaryTreeLevelOrderTraversal();
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n20.left = n15;
        n20.right = n7;
        n3.left = n9;
        n3.right = n20;

        List<List<Integer>> lists = List.of(List.of(3), List.of(9, 20), List.of(15, 7));

        Assertions.assertThat(btl.levelOrder(n3)).isEqualTo(lists);
    }
}
