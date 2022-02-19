package chapter04;

/*
* Time: O(n)
* Space: O(n)
* */

import java.util.HashMap;
import java.util.Map;

public class CheckBalanced {
    Map<TreeNode2, Integer> memo = new HashMap<>();
    int getHeight(TreeNode2 node) {
        if (node == null) return -1;

        int leftHeight;
        int rightHeight;

        if (memo.containsKey(node.left)) {
            leftHeight = memo.get(node.left);
        } else {
            leftHeight = getHeight(node.left);
        }

        if (memo.containsKey(node.right)) {
            rightHeight = memo.get(node.right);
        } else {
            rightHeight = getHeight(node.right);
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    boolean isBalanced(TreeNode2 root) {
        if (root == null) return true;

        int heightDelta = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (heightDelta > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
}
