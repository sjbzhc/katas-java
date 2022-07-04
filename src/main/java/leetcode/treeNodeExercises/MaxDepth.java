package leetcode.treeNodeExercises;

import java.util.LinkedList;
import java.util.Stack;

/*
* Time: O(n)
* Space: O(h)
* */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return Math.max(left_height, right_height) + 1;

    }

    public int maxDepthIterative(TreeNode root) {

        class Pair {
            TreeNode node;
            int depth;

            public Pair(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        Stack<Pair> stack = new Stack<>();
        if (root == null) return 0;

        stack.add(new Pair(root, 1));

        int res = 0;
        while(!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            int depth = current.depth;
            if (node != null) {
                res = Math.max(depth, res);
                stack.add(new Pair(node.left, depth + 1));
                stack.add(new Pair(node.right, depth + 1));
            }
        }
        return res;
    }
}
