package leetcode;

import leetcode.treeNodeExercises.TreeNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class StepByStepDirectionsOfBinaryTreeTests {
    @Test
    public void test() {
        StepByStepDirectionsOfBinaryTree sb = new StepByStepDirectionsOfBinaryTree();

        TreeNode tn5 = new TreeNode(5);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn4 = new TreeNode(4);

        tn2.left = tn6;
        tn2.right = tn4;

        tn1.left = tn3;

        tn5.left = tn1;
        tn5.right = tn2;

        Assertions.assertThat(sb.getDirections(tn5, 3, 6)).isEqualTo("UURL");
    }
}
