package chapter04;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CheckBalancedTests {
    @Test
    public void check_balanced() {
        CheckBalanced cb = new CheckBalanced();
        TreeNode2 tn1 = new TreeNode2(1);
        TreeNode2 tn2 = new TreeNode2(2);
        TreeNode2 tn3 = new TreeNode2(3);

        tn1.left = tn2;
        tn1.right = tn3;

        Assertions.assertThat(cb.isBalanced(tn1)).isTrue();
    }
}
