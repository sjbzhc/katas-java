package leetcode.treeNodeExercises;

import java.util.*;

public class PostOrderTraversal {
    public List<Integer> postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        Collections.reverse(list);
        return list;
    }
}
