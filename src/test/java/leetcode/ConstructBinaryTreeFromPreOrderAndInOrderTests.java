package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ConstructBinaryTreeFromPreOrderAndInOrderTests {
    @Test
    public void test() {
        ConstructBinaryTreeFromPreOrderAndInOrder cb = new ConstructBinaryTreeFromPreOrderAndInOrder();
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        Assertions.assertThat(cb.buildTree(preOrder, inOrder).toString()).isEqualTo("3920157");
    }
}
