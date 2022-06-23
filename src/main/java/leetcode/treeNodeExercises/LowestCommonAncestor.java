package leetcode.treeNodeExercises;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {
    /*
    * Time: O(n)
    * Space: O(n)
    *
    * Premise: p and q exist and have a common ancestor.
    *
    *           3
    *       9       20
    *           15      7
    *
    * First we do left and right for root 3.
    * lca(3, 9, 20)
    *   l = lca(9, 9, 20)
    *     l = lca(null, 9, 20) => null
    *     r = lca(null, 9, 20) => null
    *     set.includes(root=9) => return 9
    *   r = lca(20, 9, 20)
    *     l = lca(15, 9, 20)
    *         l = lca(null, 9, 20) => null
    *         r = lca(null, 9, 20) => null
    *         !set.includes(root=15) => return null
    *     r = lca(7, 9, 20)
    *         l = lca(null, 9, 20) => null
    *         r = lca(null, 9, 20) => null
    *         !set.includes(root=7) => return null
    *     set.includes(20) => return 20
    *   l != null && r != null => return root
    *
    * We first create the whole recursion tree (up to the point where we need it) and then the results start to be
    * generated with the leaves of the tree for each node.
    *
    * We only reach left != null && right != null when all the children of left and right were evaluated and they were
    * only returned as set.contains(root) for their own call to lca (e.g. lca(20,0,20))
    *
    * This calls left and right for 9. Since 9 as a root is included in the set of (p,q), 9 is returned.
    * For 20, we calculate left and right for 15, which return null. This will lead to a result of null. The same for 7.
    * Since set (p,q) contains 20, we return 20.
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        set.add(q);

        if (left != null && right != null || set.contains(root)) {
            return root;
        } else if (left != null) {
            return left;
        }
        else return right;
    }

    /*
     *           3
     *       9       20
     *
     * rT(3, 9, 20)
     *  left = rT(9, 9, 20)
     *      left = rT(null, 9, 20) => 0
     *      right = rT(null, 9, 20) => 0
     *      mid = node == 9 => 1
     *      return true
     *  right = rT(20, 9, 20)
     *      left = rT(null, 9, 20) => 0
     *      right = rT(null, 9, 20) => 0
     *      mid = node == 20 => 1
     *      return true
     *  mid = 3 == 9 || 3 == 20? => 0
     *      mid + left + right = 2 => ans = 3
     *  return true
     *
     * The base case is when the node is equal to p or q, which returns true.
     *
     * To set the answer, we need for 2 out of left, right and mid to return true.
    * */

    /*
    * Time: O(log n)
    * Space: O(1)
    * */
    TreeNode ans;
    public TreeNode lowestCommonAncestorCount(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }

    private boolean recurseTree(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        int left = recurseTree(node.left, p, q) ? 1 : 0;
        int right = recurseTree(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;

        if (mid + right + left >= 2) ans = node;

        return (mid + left + right > 0);
    }

    private TreeNode lowestCommonAncestorGuaranteed(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val > current.val && q.val > current.val) current = current.right;
            else if (p.val < current.val && q.val < current.val) current = current.left;
            else return current;
        }
        return current;
    }
}
