package chapter04;

public class Successor {
    public TreeNode2 successor(TreeNode2 root) {
        /*
        * If node has right child, take the leftmost child
        *
        * Otherwise, while n is right child of n.parent, we set n = parent.
        * We then return n.p
        *
        *      a
        *     /
        *    b
        *    \
        *     c
        *
        * We are looking for successor of c, so we will go up until b and then return a
        * */

        if (root.right != null) {
            return findLeftMost(root);
        } else {
            return findRightParent(root);
        }
    }

    private TreeNode2 findRightParent(TreeNode2 root) {
        if (root == null) return null;

        while (root == root.parent.right) {
            root = root.parent;
        }

        return root.parent;
    }

    private TreeNode2 findLeftMost(TreeNode2 root) {
        if (root == null) return null;

        TreeNode2 temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
}
