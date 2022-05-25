package leetcode;

import leetcode.treeNodeExercises.PathSum;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PathSumTests {
    @Test
    public void path_sum() {
        PathSum ps = new PathSum();
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        n5.left = n4;

        Assertions.assertThat(ps.hasPathSum(n5, 9)).isTrue();
    }
}

