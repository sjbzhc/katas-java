package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class HeightOfTreeTests {
    @Test
    public void test() {
        HeightOfTree ht = new HeightOfTree();

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n0.left = n1;
        n0.right = n1;
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;

        Assertions.assertThat(ht.height(n0)).isEqualTo(4);
    }

    @Test
    public void test_2() {
        HeightOfTree ht = new HeightOfTree();

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n0.left = n1;
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;

        Assertions.assertThat(ht.height(n0)).isEqualTo(5);
    }

    @Test
    public void test_3() {
        HeightOfTree ht = new HeightOfTree();

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;

        Assertions.assertThat(ht.height(n0)).isEqualTo(3);
    }
}
