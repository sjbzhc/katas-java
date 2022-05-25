package leetcode;

import leetcode.treeNodeExercises.MaxDepth;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import leetcode.treeNodeExercises.TreeNode;

public class MaxDepthTests {
    @Test
    public void max_depth() {
        MaxDepth md = new MaxDepth();
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n20.left = n15;
        n20.right = n7;

        n3.left = n9;
        n3.right = n20;

        Assertions.assertThat(md.maxDepth(n3)).isEqualTo(3);

    }

    @Test
    public void max_depth_iterative() {
        MaxDepth md = new MaxDepth();
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n20.left = n15;
        n20.right = n7;

        n3.left = n9;
        n3.right = n20;

        Assertions.assertThat(md.maxDepthIterative(n3)).isEqualTo(3);

    }
}
