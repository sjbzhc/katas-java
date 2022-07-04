package leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    /*
    * Time: O(n)
    * Space: O(h)
    * */
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideViewRecursive(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int i) {
        if (i == res.size()) res.add(root.val);

        if (root.right != null) helper(root.right, i + 1);
        if (root.left != null) helper(root.left, i + 1);
    }


    /*
    * Time: O(n)
    * Space: O(n)
    * */

    List<Integer> resBfs = new ArrayList<>();
    List<List<Integer>> byLevel = new ArrayList<>();
    public List<Integer> rightSideViewDfs(TreeNode root) {
        if (root == null) return resBfs;
        buildLevels(root, 0);
        getResult();
        return resBfs;
    }

    private void getResult() {
        for(int i=0; i<byLevel.size(); i++) {
            List<Integer> list = byLevel.get(i);
            resBfs.add(list.get(list.size() - 1));
        }
    }

    private void buildLevels(TreeNode root, int i) {
        if (root == null) return;
        if (i == byLevel.size()) byLevel.add(new ArrayList<>());
        byLevel.get(i).add(root.val);
        if (root.left != null) buildLevels(root.left, i + 1);
        if (root.right != null) buildLevels(root.right, i + 1);
    }
}
