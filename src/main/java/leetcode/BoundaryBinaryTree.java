package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */
public class BoundaryBinaryTree {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);

        TreeNode current = root.left;
        while (current != null) {
            if (!isLeaf(current)) res.add(current.val);
            if (current.left != null) current = current.left;
            else current = current.right;
        }

        addLeaves(root);
        Stack<Integer> stack = new Stack<>();
        current = root.right;

        while (current != null) {
            if (!isLeaf(current)) stack.push(current.val);
            if (current.right != null) current = current.right;
            else current = current.left;
        }
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(TreeNode root) {
        if (isLeaf(root)) res.add(root.val);

        if (root.left != null) addLeaves(root.left);
        if (root.right != null) addLeaves(root.right);

    }
}
