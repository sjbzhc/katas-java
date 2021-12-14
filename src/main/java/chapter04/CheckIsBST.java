package chapter04;

public class CheckIsBST {

    public boolean isBST(TreeNode2 node) {
        return check(node, null, null);
    }

    private boolean check(TreeNode2 node, Integer min, Integer max) {
        // base case
        if (node == null) return true;

        // if data is outside of the boundaries, return false
        if ((min != null && node.data <= min) || (max != null && node.data > max)) return false;

        // if any of the children fails the check, return false
        if (!(check(node.left, null, node.data) && check(node.right, node.data, null))) return false;

        // only if we pass all tests return true
        return true;
    }
}
