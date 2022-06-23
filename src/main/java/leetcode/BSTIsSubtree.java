package leetcode;

/*
* Time: O(p * q)
* Space: O(p)
* */
public class BSTIsSubtree {
    BSTIsSameTree bstIsSameTree = new BSTIsSameTree();
    public boolean isSubtree(TreeNode p, TreeNode q) {
        if (q == null) return true;
        if (p == null) return false;

        if (bstIsSameTree.isSameTree(p, q)) return true;

        return bstIsSameTree.isSameTree(p.left, q) || bstIsSameTree.isSameTree(p.right, q);
    }
}
