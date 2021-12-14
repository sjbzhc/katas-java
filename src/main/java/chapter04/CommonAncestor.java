package chapter04;

public class CommonAncestor {

    public TreeNode2 commonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (!covers(root, p) || !covers(root, q)) return null;

        return ancestorHelper(root, p, q);
    }

    private TreeNode2 ancestorHelper(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);

        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }

        TreeNode2 childSide = pIsOnLeft ? root.left : root.right;

        return ancestorHelper(childSide, p, q);
    }

    private boolean covers(TreeNode2 root, TreeNode2 q) {
        if (root == null) return false;
        if (root == q) return true;
        return covers(root.left, q) || covers(root.right, q);
    }
}
