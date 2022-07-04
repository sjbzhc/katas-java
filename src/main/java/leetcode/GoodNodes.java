package leetcode;

/*
* Time: O(n)
* Space: O(h)
* */

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxValue) {
        if (root == null) return 0;

        maxValue = Math.max(maxValue, root.val);
        int res = root.val < maxValue ? 0 : 1;
        res += dfs(root.left, maxValue);
        res += dfs(root.right, maxValue);
        return res;
    }
}
