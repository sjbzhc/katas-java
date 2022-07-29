package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BoundaryBinaryTreeTests {
    @Test
    public void test() {
        BoundaryBinaryTree bb = new BoundaryBinaryTree();

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);

        tn2.left = tn3;
        tn2.right = tn4;
        tn1.right = tn2;

        Assertions.assertThat(bb.boundaryOfBinaryTree(tn1)).isEqualTo(List.of(1,3,4,2));
    }
}
