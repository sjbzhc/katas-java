package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class EvenOddTreeTests {
    @Test
    public void test() {
        EvenOddTree eo = new EvenOddTree();

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn10 = new TreeNode(10);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn7 = new TreeNode(7);

        tn1.left = tn10;
        tn1.right = tn4;

        tn10.left = tn3;
        tn4.left = tn7;

        Assertions.assertThat(eo.isEvenOddTree(tn1)).isTrue();
    }

    @Test
    public void test_2() {
        EvenOddTree eo = new EvenOddTree();

        TreeNode tn5 = new TreeNode(5);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn5_2 = new TreeNode(5);
        TreeNode tn7 = new TreeNode(7);

        tn5.left = tn9;
        tn5.right = tn1;

        tn9.left = tn3;
        tn9.right = tn5_2;

        tn1.left = tn7;

        Assertions.assertThat(eo.isEvenOddTree(tn5)).isFalse();
    }
}
