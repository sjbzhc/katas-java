package chapter04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateLevelLinkedLists {
    public List<LinkedList<Integer>> create(TreeNode2 node) {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        createLists(node, lists, 0);
        return lists;
    }

    private void createLists(TreeNode2 node, List<LinkedList<Integer>> lists, int depth) {
        if (node == null) return;
        LinkedList<Integer> list;
        if (lists.size() == depth) {
             list = new LinkedList<>();
             lists.add(list);
        } else {
            list = lists.get(depth);
        }
        list.add(node.data);
        createLists(node.left, lists, depth + 1);
        createLists(node.right, lists, depth + 1);
    }

    public List<LinkedList<Integer>> createListsBFS(TreeNode2 root) {
        List<LinkedList<Integer>> lists = new ArrayList<>();

        LinkedList<TreeNode2> current = new LinkedList<>();
        LinkedList<Integer> currentRes = new LinkedList<>();

        current.add(root);
        currentRes.add(root.data);

        while (current.size() > 0) {
            lists.add(currentRes);
            LinkedList<TreeNode2> parents = current;
            current = new LinkedList<>();
            currentRes = new LinkedList<>();
            for (TreeNode2 n : parents) {
                if (n.left != null) current.add(n.left);
                if (n.left != null) currentRes.add(n.left.data);
                if (n.right != null) current.add(n.right);
                if (n.right != null) currentRes.add(n.right.data);
            }
        }

        return lists;
    }
}
