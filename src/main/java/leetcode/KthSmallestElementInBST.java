package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Time: O(h)
* Space: O(h)
* */

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--;
            if (k == 0) return current.val;
            current = current.right;
        }
        return -1;
    }
}
