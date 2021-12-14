package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class SuccessorTests {
    @Test
    public void successor() {
        Successor successor = new Successor();

        TreeNode2 node50 = new TreeNode2(50);
        TreeNode2 node25 = new TreeNode2(25);
        TreeNode2 node100 = new TreeNode2(100);
        TreeNode2 node5 = new TreeNode2(5);
        TreeNode2 node40 = new TreeNode2(40);

        node25.left = node5;
        node5.parent = node25;
        node25.right = node40;
        node40.parent = node25;
        node50.left = node25;
        node25.parent = node50;
        node50.right = node100;
        node100.parent = node50;

        Assertions.assertThat(successor.successor(node5)).isEqualTo(node25);
    }

    @Test
    public void successor_long() {
        Successor successor = new Successor();

        TreeNode2 node50 = new TreeNode2(50);
        TreeNode2 node25 = new TreeNode2(25);
        TreeNode2 node100 = new TreeNode2(100);
        TreeNode2 node5 = new TreeNode2(5);
        TreeNode2 node40 = new TreeNode2(40);
        TreeNode2 node75 = new TreeNode2(75);
        TreeNode2 node80 = new TreeNode2(80);
        TreeNode2 node120 = new TreeNode2(120);
        TreeNode2 node150 = new TreeNode2(150);

        node25.left = node5;
        node5.parent = node25;
        node25.right = node40;
        node40.parent = node25;
        node50.left = node25;
        node25.parent = node50;
        node50.right = node100;
        node100.parent = node50;

        node75.right = node80;
        node80.parent = node75;
        node75.parent = node100;
        node100.left = node75;

        node120.right = node150;
        node150.parent = node120;
        node100.right = node120;
        node120.parent = node100;

        Assertions.assertThat(successor.successor(node80)).isEqualTo(node100);
    }
}
