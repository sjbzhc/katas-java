package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LeftSideViewTests {
    @Test
    public void test() {
        LeftSideView ls = new LeftSideView();
        TreeNode tn = new TreeNode(0);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        tn.left = tn1;
        tn.right = tn2;
        tn1.left = tn3;

        List<Integer> res = List.of(0, 1, 3);

        Assertions.assertThat(ls.leftSideView(tn)).isEqualTo(res);

    }
}
