package leetcode.treeNodeExercises;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if (root.left != null) helper(root.left, level + 1);
        if (root.right != null) helper(root.right, level + 1);
    }
}
