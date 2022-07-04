package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Time: O(n)
* Space: O(n)
* */


public class ConstructBinaryTreeFromPreOrderAndInOrder {
    int preorderIndex = 0;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) inorderIndexMap.put(inorder[i], i);

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        int m = inorderIndexMap.get(rootValue);
        root.left = arrayToTree(preorder, left, m - 1);
        root.right = arrayToTree(preorder, m + 1, right);
        return root;
    }
}
