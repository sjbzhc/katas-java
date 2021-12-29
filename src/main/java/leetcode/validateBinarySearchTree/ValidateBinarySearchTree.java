package leetcode.validateBinarySearchTree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;

        if (low != null && node.val <= low || high != null && node.val >= high) {
            return false;
        }

        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}
