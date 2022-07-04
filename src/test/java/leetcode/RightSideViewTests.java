package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class RightSideViewTests {
    @Test
    public void test() {
        RightSideView rs = new RightSideView();
        TreeNode tn = new TreeNode(0);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        tn.left = tn1;
        tn.right = tn2;
        tn1.left = tn3;

        List<Integer> res = List.of(0, 2, 3);

        Assertions.assertThat(rs.rightSideViewRecursive(tn)).isEqualTo(res);
        Assertions.assertThat(rs.rightSideViewDfs(tn)).isEqualTo(res);

    }
}
