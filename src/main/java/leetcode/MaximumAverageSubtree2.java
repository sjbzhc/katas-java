package leetcode;

public class MaximumAverageSubtree2 {
    double max = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode treeNode) {
        maxSubTree(treeNode);
        return max;
    }

    private int[] maxSubTree(TreeNode treeNode) {
        if (treeNode == null) return new int[]{0,0};

        int[] left = maxSubTree(treeNode.left);
        int[] right = maxSubTree(treeNode.right);

        int sum = left[0] + right[0] + treeNode.val;
        int count = left[1] + right[1] + 1;

        double avg = sum / count;

        if (avg > max) max = avg;

        return new int[]{sum, count};
    }
}
