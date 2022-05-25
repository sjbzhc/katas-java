package leetcode;

import leetcode.treeNodeExercises.BinaryTreeZigzag;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class BinaryTreeZigzagTests {
    @Test
    public void binary_tree_zigzag() {
        BinaryTreeZigzag bt = new BinaryTreeZigzag();
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn20 = new TreeNode(20);
        TreeNode tn15 = new TreeNode(15);
        TreeNode tn7 = new TreeNode(7);

        tn20.left = tn15;
        tn20.right = tn7;
        tn3.left = tn9;
        tn3.right = tn20;

        List<List<Integer>> expected = List.of(List.of(3), List.of(20, 9), List.of(15,7));
        Assertions.assertThat(bt.zigzagLevelOrder(tn3)).isEqualTo(expected);
    }

    @Test
    public void binary_tree_zigzag_dq() {
        BinaryTreeZigzag bt = new BinaryTreeZigzag();
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn20 = new TreeNode(20);
        TreeNode tn15 = new TreeNode(15);
        TreeNode tn7 = new TreeNode(7);

        tn20.left = tn15;
        tn20.right = tn7;
        tn3.left = tn9;
        tn3.right = tn20;

        List<List<Integer>> expected = List.of(List.of(3), List.of(9, 20), List.of(15,7));
        Assertions.assertThat(bt.zigzagLevelOrderDq(tn3)).isEqualTo(expected);
    }
}
