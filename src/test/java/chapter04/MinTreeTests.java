package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class MinTreeTests {
    @Test
    public void min_tree() {
        MinTree minTree = new MinTree();
        int[] arr = {0,1,2,3,4,5};
        TreeNode2 node0 = new TreeNode2(0);
        TreeNode2 node1 = new TreeNode2(1);
        TreeNode2 node2 = new TreeNode2(2);
        TreeNode2 node3 = new TreeNode2(3);
        TreeNode2 node4 = new TreeNode2(4);
        TreeNode2 node5 = new TreeNode2(5);

        node0.right = node1;
        node2.left = node0;

        node4.left = node3;
        node4.right = node5;
        node2.right = node4;

        TreeNode2 result = minTree.fromArray(arr);

        Assertions.assertThat(node2.toString()).isEqualTo(result.toString());
    }
}
