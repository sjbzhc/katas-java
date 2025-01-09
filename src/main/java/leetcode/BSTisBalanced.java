package leetcode;

public class BSTisBalanced {


    /*
    * Time: O(n log n)
    * Space: O(n)
    * */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

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
    public boolean isBalancedWithHelper(TreeNode root) {
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
