package leetcode;

import leetcode.treeNodeExercises.TreeNode;

/*
* Time: O(V + E)
* Space: O(h)
* */

public class StepByStepDirectionsOfBinaryTree {
    String srcPathHalf = "";
    String destPathHalf ="";
    int src;
    int dest;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        src = startValue;
        dest = destValue;
        lca(root, startValue, destValue);
        helper(lca,"", "");
        return srcPathHalf + destPathHalf;


    }
    public void helper(TreeNode root, String srcPath, String destPath){
        if (root == null) return;
        if (root.val == src) srcPathHalf += srcPath;
        else if (root.val == dest) destPathHalf += destPath;
        helper(root.left, srcPath + "U",  destPath + "L");
        helper(root.right, srcPath + "U", destPath + "R");
        return;
    }

    TreeNode lca;
        public boolean lca(TreeNode root, int p, int q){
        if(root == null) return false;

        int left = lca(root.left, p, q) ? 1 : 0;
        int right = lca(root.right, p, q) ? 1 : 0;
        int mid = (root.val == p || root.val == q) ? 1 : 0;

        if (left + right + mid >= 2) lca = root;
        return left + right + mid > 0;
    }
}
