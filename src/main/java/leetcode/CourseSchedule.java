package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
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

        int[] order;

        if (isPossible) {
            order = new int[numCourses];
            for (int i=0; i<numCourses;i++) {
                order[i] = topologicalOrder.get(numCourses -i -1);
            }
        } else {
            order = new int[0];
        }
        return order;
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
            }
        }

        color.put(course, BLACK);
        topologicalOrder.add(course);

    }

    private void createGraph(int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
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
