package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeftSideView {
    List<Integer> res = new ArrayList();
    public List<Integer> leftSideView(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int i) {
        if (i == res.size()) res.add(root.val);

        if (root.left != null) helper(root.left, i + 1);
        if (root.right != null) helper(root.right, i + 1);
    }
}
