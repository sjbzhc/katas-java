package leetcode.treeNodeExercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.addFirst(current.val);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        return list;
    }
}
