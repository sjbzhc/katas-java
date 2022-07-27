package leetcode;

import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class FindLeavesOfBinaryTreeTests {
    @Test
    public void test() {
        FindLeavesOfBinaryTree fl = new FindLeavesOfBinaryTree();

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);

        tn2.left = tn4;
        tn2.right = tn5;
        tn1.left = tn2;
        tn1.right = tn3;

        List<List<Integer>> res = List.of(List.of(4,5,3), List.of(2), List.of(1));

        Assertions.assertThat(fl.findLeaves(tn1)).isEqualTo(res);
    }
}
