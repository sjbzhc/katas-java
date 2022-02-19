package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SerializeBinaryTreeTests {
    @Test
    public void serialize_binary_tree() {
        SerializeBinaryTree sb = new SerializeBinaryTree();
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        tn3.left = tn4;
        tn3.right = tn5;
        tn1.left = tn2;
        tn1.right = tn3;

        Assertions.assertThat(sb.serialize(tn1)).isEqualTo("1,2,null,null,3,4,null,null,5,null,null,");

        Assertions.assertThat(sb.serialize(sb.deserialize("1,2,null,null,3,4,null,null,5,null,null"))).isEqualTo(sb.serialize(tn1));

    }
}
