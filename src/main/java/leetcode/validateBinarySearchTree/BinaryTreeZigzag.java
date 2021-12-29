package leetcode.validateBinarySearchTree;

import java.util.*;

/*
* Time: O(n), we visit each node only once
* Space: O(h), depending on the height of the tree. The call stack will have, in a balance tree, H = lg2 N
*
* */

public class BinaryTreeZigzag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        dfs(root, 0, result, visited);
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result, Map<TreeNode, Boolean> visited) {
        if (node == null) return;
        if (visited.getOrDefault(node, false)) return;

        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);
        visited.put(node, true);

        if (node.left != null) dfs(node.left, level + 1, result, visited);
        if (node.right != null) dfs(node.right, level + 1, result, visited);

        }
}
