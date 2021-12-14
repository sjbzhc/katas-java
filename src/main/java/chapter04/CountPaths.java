package chapter04;

import java.util.List;

public class CountPaths {

    public int countPaths(TreeNodeGeneric root, int targetSum) {
        if (root == null) return 0;

        int sum = countPathsWithSumFromNode(root, targetSum, 0);

        List<TreeNodeGeneric> children = root.children;

        for (TreeNodeGeneric c : children) {
            sum += countPaths(c, targetSum);
        }
        return sum;
    }

    private int countPathsWithSumFromNode(TreeNodeGeneric root, int targetSum, int currentSum) {
        if (root == null) return 0;

        currentSum += (int) root.data;

        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        List<TreeNodeGeneric> children = root.children;

        for (TreeNodeGeneric c : children) {
            totalPaths += countPathsWithSumFromNode(c, targetSum, currentSum);
        }

        return totalPaths;

    }


}
