package leetcode.treeNodeExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> solution = new ArrayList<>();

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            solution.add(current.val);
            current = current.right;
        }
        return solution;
    }
}
