package leetcode;

/*
* Time: O(p * q)
* Space: O(p)
* */
public class BSTIsSubtree {
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;

        if (isEqual(t1, t2)) return true;

        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    public boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;

        if (t1 != null && t2 == null || t1 == null && t2 != null) return false;

        return t1.val == t2.val && isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }
}
