package leetcode.treeNodeExercises;

/*
* Time: O(n)
* Space: O(n)
* */

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return checkIsSymmetric(root, root);
    }

    private boolean checkIsSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;

        return root1.val == root2.val && checkIsSymmetric(root1.left, root2.right) && checkIsSymmetric(root1.right, root2.left);
        }
}
