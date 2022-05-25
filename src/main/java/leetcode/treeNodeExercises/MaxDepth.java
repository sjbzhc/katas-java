package leetcode.treeNodeExercises;

import java.util.LinkedList;
import java.util.Stack;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    public int maxDepthIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0;
        int current_depth = 0;
        while(!stack.isEmpty()) {
            root = stack.pop();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }
}
