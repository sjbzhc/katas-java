package leetcode;

public class HeightOfTree {
    int max = 0;
    public int height(TreeNode node) {
        dfs(node, 0);
        return max;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);

        max = Math.max(depth, max);
    }
}
