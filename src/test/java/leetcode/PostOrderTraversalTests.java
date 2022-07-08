package leetcode;

import leetcode.treeNodeExercises.PostOrderTraversal;
import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PostOrderTraversalTests {
    @Test
    public void post_order_traversal() {
        PostOrderTraversal po = new PostOrderTraversal();
        leetcode.treeNodeExercises.TreeNode n1 = new leetcode.treeNodeExercises.TreeNode(1);
        leetcode.treeNodeExercises.TreeNode n2 = new leetcode.treeNodeExercises.TreeNode(2);
        leetcode.treeNodeExercises.TreeNode n3 = new TreeNode(3);

        n2.left = n3;
        n1.right = n2;

        List<Integer> list = List.of(3,2,1);

        Assertions.assertThat(po.postOrderTraversal(n1)).isEqualTo(list);
    }
}
