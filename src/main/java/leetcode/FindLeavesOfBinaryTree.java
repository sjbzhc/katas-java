package leetcode;

import leetcode.treeNodeExercises.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(n)
* Space: O(n)
* */

public class FindLeavesOfBinaryTree {
    private List<List<Integer>> solution;

    public List<List<Integer>> findLeaves(TreeNode root) {
        solution = new ArrayList<>();
        getHeight(root);
        return solution;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        if (solution.size() == currHeight) solution.add(new ArrayList<>());

        solution.get(currHeight).add(root.val);

        return currHeight;
    }
}
