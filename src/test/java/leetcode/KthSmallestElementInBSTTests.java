package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class KthSmallestElementInBSTTests {
    @Test
    public void test() {
        KthSmallestElementInBST ks = new KthSmallestElementInBST();

        TreeNode tn = new TreeNode(3);
        TreeNode tnL = new TreeNode(1);
        TreeNode tnR = new TreeNode(4);
        TreeNode tnLR = new TreeNode(2);

        tn.left = tnL;
        tn.right = tnR;
        tnL.right = tnLR;

        Assertions.assertThat(ks.kthSmallest(tn, 1)).isEqualTo(1);
    }
}
