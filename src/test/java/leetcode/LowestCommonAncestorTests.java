package leetcode;

import leetcode.treeNodeExercises.LowestCommonAncestor;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class LowestCommonAncestorTests {
    @Test
    public void lowest_common_ancestor() {
        LowestCommonAncestor lc = new LowestCommonAncestor();

        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n20.left = n15;
        n20.right = n7;
        n3.left = n9;
        n3.right = n20;

        Assertions.assertThat(lc.lowestCommonAncestor(n3, n9, n20)).isEqualTo(n3);
    }

    @Test
    public void lowest_common_ancestor_count() {
        LowestCommonAncestor lc = new LowestCommonAncestor();

        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n20.left = n15;
        n20.right = n7;
        n3.left = n9;
        n3.right = n20;

        Assertions.assertThat(lc.lowestCommonAncestorCount(n3, n9, n20)).isEqualTo(n3);
    }
}
