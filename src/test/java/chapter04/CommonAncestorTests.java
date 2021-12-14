package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class CommonAncestorTests {
    @Test
    public void common_ancestor() {
        CommonAncestor commonAncestor = new CommonAncestor();
        TreeNode2 node50 = new TreeNode2(50);
        TreeNode2 node25 = new TreeNode2(25);
        TreeNode2 node100 = new TreeNode2(100);
        TreeNode2 node5 = new TreeNode2(5);
        TreeNode2 node40 = new TreeNode2(40);

        node25.left = node5;
        node25.right = node40;
        node50.left = node25;
        node50.right = node100;

        Assertions.assertThat(commonAncestor.commonAncestor(node50, node5, node100)).isEqualTo(node50);
    }
}
