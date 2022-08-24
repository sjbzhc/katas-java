package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                size--;
                TreeNode current = q.poll();
                if (levels.size() == count) levels.add(new ArrayList<>());
                levels.get(count).add(current.val);

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            count++;
        }

        for (int i=0; i<levels.size(); i++) {
            if (!validate(i, levels.get(i))) return false;
        }

        return true;
    }

    public boolean validate(int index, List<Integer> list) {
        if (list.size() == 1) return true;
        if (index % 2 == 0) {
            for (int i=1; i<list.size(); i++) {
                int prev = list.get(i-1);
                int curr = list.get(i);
                if (prev >= curr || prev % 2 == 0 || curr % 2 == 0) return false;
            }
            return true;
        } else {
            for (int i=1; i<list.size(); i++) {
                int prev = list.get(i-1);
                int curr = list.get(i);
                if (prev <= curr || prev % 2 != 0 || curr % 2 != 0) return false;
            }
            return true;
        }
    }
}
