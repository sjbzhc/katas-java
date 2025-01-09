package leetcode.treeNodeExercises;

/*
* Time: O(n)
* Space: O(n)
*
* Diameter is at a node is the sum of it the depths for the left and right nodes.
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

        // Don't need to add 1 as by definition, the diameter does not include root
        diameter = Math.max(diameter, left + right);

        // Add 1 as this represents the height of the current node
        return Math.max(left, right) + 1;
    }
}
