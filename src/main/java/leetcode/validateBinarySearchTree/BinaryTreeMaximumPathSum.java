package leetcode.validateBinarySearchTree;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int newPrice = node.val + leftGain + rightGain;

        // Used for final result. End result can take both children, as it's only branching once
        maxSum = Math.max(newPrice, maxSum);

        // Used for recursion. We only take one child, as we cannot branch off more than once.
        return node.val + Math.max(leftGain, rightGain);
    }
}
