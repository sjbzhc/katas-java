package leetcode.treeNodeExercises;

import java.util.*;

/*
* Time: O(n), we visit each node only once
* Space: O(h), depending on the height of the tree. The call stack will have, in a balance tree, H = lg2 N
*
* */

public class BinaryTreeZigzag {
    Set<TreeNode> visited = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return result;
        dfs(root, 0);
        for (int i=0;i<result.size();i++) {
            if (i % 2 != 0) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    public void dfs(TreeNode node, int depth) {
        if (visited.contains(node)) return;

        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(node.val);
        visited.add(node);

        if (node.left != null) dfs(node.left, depth + 1);
        if (node.right != null) dfs(node.right, depth + 1);
    }

    public List<List<Integer>> zigzagLevelOrderDq(TreeNode root) {
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            result.add(list);
            boolean leftToRight = false;
            while (size > 0) {
                TreeNode current = queue.poll();
                if (leftToRight) {
                    list.addFirst(current.val);
                } else {
                    list.addLast(current.val);
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                size--;
            }
            leftToRight = !leftToRight;
        }
        return result;
    }
}
