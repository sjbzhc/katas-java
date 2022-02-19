package chapter04;

import java.util.LinkedList;

/*
* Time: O(E + V)
* Space: O(E + V)
* */

public class RouteBetweenNodes {

    enum States {VISITED, NOT_VISITED, VISITING }

    boolean search(Graph g, TreeNode start, TreeNode end) {
        if (start == end) return true;

        for (TreeNode n : g.nodes) {
            n.status = States.NOT_VISITED.toString();
        }

        /*
        * We first check the children of the current node for a direct match. if they don't match, we mark them as
        * visited and add them to the queue so that their respective children can be analyzed.
        *
        * This is BFS, since we will first visit all the children of the current node, before moving on to the next
        * child children.
        *
        * */

        LinkedList<TreeNode> q = new LinkedList<>();
        start.status = States.VISITING.toString();
        q.offer(start);
        while (!q.isEmpty()) {
            TreeNode u = q.poll();
            if (u != null) {
                for (TreeNode n : u.children) {
                    if (n.status.equals(States.VISITING.toString())) continue;
                    if (n.status.equals(States.NOT_VISITED.toString())) {
                        if (n == end) {
                            return true;
                        } else {
                            n.status = States.VISITING.toString();
                            q.add(n);
                        }
                    }
                }
                u.status = States.VISITED.toString();
            }
        }
        return false;
    }
}
