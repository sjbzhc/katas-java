package leetcode;

import java.util.*;

public class CourseSchedule2 {
    int WHITE = 0;
    int GRAY = 1;
    int BLACK = 2;
    int[] colors;
    boolean canBeSolved = true;
    Map<Integer, List<Integer>> adj;
    List<Integer> topologicalSort = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = buildAdj(prerequisites);
        colors = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (colors[course] == WHITE) {
                dfs(course);
            }
        }

        if (!canBeSolved) return new int[]{0};

        int[] finalResult = new int[numCourses];
        int index = 0;

        for (int i = numCourses -1; i>= 0; i--) {
            finalResult[index] = topologicalSort.get(i);
            index++;
        }

        return finalResult;
    }

    private void dfs(int course) {
        if(!canBeSolved) return;

        colors[course] = GRAY;

        for (int neighbour : adj.getOrDefault(course, new ArrayList<>())) {
            if (colors[neighbour] == WHITE) {
                dfs(neighbour);
            } else if (colors[neighbour] == GRAY) {
                canBeSolved = false;
            }
        }

        topologicalSort.add(course);
        colors[course] = BLACK;
    }

    private Map<Integer, List<Integer>> buildAdj(int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] p : prerequisites) {
            int src = p[1];
            int dest = p[0];
            List<Integer> list = adj.getOrDefault(src, new ArrayList<>());
            if (!list.contains(dest)) list.add(dest);
            adj.put(src, list);
        }
        return adj;
    }
}
