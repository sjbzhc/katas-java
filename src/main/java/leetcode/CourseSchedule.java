package leetcode;

import java.util.*;

/*
* Time: O(V + E)
* Space: O(V + E)
* We use DFS, since we want to get to the bottom of the 'tree'. A node at the bottom of the 'tree' has no dependencies.
*
* Gray represents a node that is being currently inspected. If during this dfs recursion we encounter another gray node
* it means that we have a cycle and no order is possible.
*
* */

public class CourseSchedule {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
    boolean isPossible = true;
    Map<Integer, Integer> color = new HashMap<>();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    List<Integer> topologicalOrder = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);
        createGraph(prerequisites);

        for (int i=0; i< numCourses; i++) {
            if(color.get(i) == WHITE) {
                dfs(i);
            }
        }

        if (!isPossible) return new int[]{};
        Collections.reverse(topologicalOrder);
        return topologicalOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int course) {
        if (!isPossible) {
            return;
        }

        color.put(course, GRAY);

        for (int neighbor : adjList.getOrDefault(course, new ArrayList<>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GRAY) {
                isPossible = false;
                break;
            }
        }

        color.put(course, BLACK);
        topologicalOrder.add(course);

    }

    private void createGraph(int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int src = prerequisite[1];
            int dest = prerequisite[0];
            List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjList.put(src, list);
        }
    }

    private void init(int numCourses) {
        for(int i=0; i< numCourses; i++) {
            color.put(i, WHITE);
        }
    }
}
