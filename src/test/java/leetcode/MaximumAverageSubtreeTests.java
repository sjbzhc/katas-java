package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaximumAverageSubtreeTests {
    @Test
    public void maximum_average_subtree() {
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t1 = new TreeNode(1);
        t5.left = t6;
        t5.right = t1;
        MaximumAverageSubtree ma = new MaximumAverageSubtree();
        Assertions.assertThat(ma.maximumAverageSubtree(t5)).isEqualTo(6);
    }

    @Test
    public void maximum_average_subtree_2() {
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t1 = new TreeNode(1);
        t5.left = t6;
        t5.right = t1;
        MaximumAverageSubtree2 ma = new MaximumAverageSubtree2();
        Assertions.assertThat(ma.maximumAverageSubtree(t5)).isEqualTo(6);
    }
}
