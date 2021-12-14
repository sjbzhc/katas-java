package leetcode;

/*
* We do dfs with post order traversal, as we need the values of the children before we can compute the total value
* at the node level.
* */

public class MaximumAverageSubtree {
    double max = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode tree) {
        dfs(tree);
        return max;
    }

    private int[] dfs(TreeNode tree) {
        if (tree == null) return new int[]{0,0};

        int left[] = dfs(tree.left);
        int right[] = dfs(tree.right);

        int totalSum = left[0] + right[0] + tree.val;
        int totalCount = left[1] + right[1] + 1;

        max = Math.max(max, (double) totalSum / totalCount);
        return new int[]{totalSum, totalCount};
     }
}
