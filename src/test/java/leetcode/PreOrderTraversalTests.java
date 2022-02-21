package leetcode;

import leetcode.treeNodeExercises.PreOrderTraversal;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PreOrderTraversalTests {
    @Test
    public void pre_order_traversal() {
        PreOrderTraversal po = new PreOrderTraversal();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n2.left = n3;
        n1.right = n2;

        List<Integer> list = List.of(1,2,3);

        Assertions.assertThat(po.preorderTraversal(n1)).isEqualTo(list);
    }
}
