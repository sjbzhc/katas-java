package leetcode;

import javafx.util.Pair;

import java.util.Stack;

/*
* dfs with stack. Use Pair to store Node, Current value (sum of all previous nodes in decimal)
* When we reach a leaf (both children == null), we add the current value to the total sum
* */

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        int totalSum = 0;
        int leafSum;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            leafSum = p.getValue();

            if (root != null) {
                leafSum = leafSum * 10 + root.val;
                // if it's a leaf, update root-to-leaf sum
                if (root.left == null && root.right == null) {
                    totalSum += leafSum;
                } else {
                    stack.push(new Pair(root.right, leafSum));
                    stack.push(new Pair(root.left, leafSum));
                }
            }
        }
        return totalSum;
    }
}
