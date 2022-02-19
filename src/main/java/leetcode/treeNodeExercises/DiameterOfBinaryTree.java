package leetcode.treeNodeExercises;

/*
* Time: O(n)
* Space: O(n)
* */

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null) return 0;

        int left = longestPath(node.left);
        int right = longestPath(node.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
