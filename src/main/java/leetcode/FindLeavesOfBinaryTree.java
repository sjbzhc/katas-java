package leetcode;

import leetcode.treeNodeExercises.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(n)
* Space: O(n)
*
* We are counting the depth from the bottom. So first we will locate all leafs
* */

public class FindLeavesOfBinaryTree {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);
        return res;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // At the beginning, res.size is 0. currHeight is also 0 (null leads to -1, which is compensated with +1 above)
        if (res.size() == currHeight) res.add(new ArrayList<>());

        res.get(currHeight).add(root.val);

        return currHeight;
    }
}
