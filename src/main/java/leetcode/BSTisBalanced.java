package leetcode;

public class BSTisBalanced {

    class Pair {
        boolean isBalanced;
        int depth;

        public Pair(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }

    /*
    * Time: O(n)
    * Space: O(n)
    * */
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }

    public Pair dfs(TreeNode root) {
        if (root == null) return new Pair(true, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <= 1;

        return new Pair(isBalanced, Math.max(left.depth, right.depth) + 1);
    }
}
