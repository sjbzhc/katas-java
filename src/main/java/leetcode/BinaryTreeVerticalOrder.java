package leetcode;

import javafx.util.Pair;

import java.util.*;

/*
* Time: O(n log n)
* Space: O(n)
*
* Travers via BFS. Add information on column relative to root (-1 to the left, +1 to the right).
* Keep Map that links column index to List of node values
*   Since we use a list, the row order is kept, as we start from root (top) and go down to leafs (bottom).
* Take keySet of map and sort it (this gives us the numerically ascending list of keys of the map).
* Add the contents of the map to the res
* */

public class BinaryTreeVerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> columnToNodes = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode currentNode = p.getKey();
            int currentCol = p.getValue();

            if (currentNode != null) {
                if (!columnToNodes.containsKey(currentCol)) {
                    columnToNodes.put(currentCol, new ArrayList<>());
                }
                columnToNodes.get(currentCol).add(currentNode.val);

                q.offer(new Pair<>(currentNode.left, currentCol - 1));
                q.offer(new Pair<>(currentNode.right, currentCol + 1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(columnToNodes.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
            res.add(columnToNodes.get(k));
        }

        return res;
    }
}
