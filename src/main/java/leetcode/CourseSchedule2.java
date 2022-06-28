package leetcode;

import java.util.*;

public class CourseSchedule2 {
    int WHITE = 0;
    int GRAY = 1;
    int BLACK = 2;
    int[] colors;
    boolean canBeSolved = true;
    List<Integer> topologicalSort = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dependencies = buildGraph(prerequisites);
        colors = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (colors[course] == WHITE) {
                dfs(course, dependencies);
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

    private void dfs(int course, Map<Integer, List<Integer>> dependencies) {
        if(!canBeSolved) return;

        colors[course] = GRAY;

        for (int neighbour : dependencies.getOrDefault(course, new ArrayList<>())) {
            if (colors[neighbour] == WHITE) {
                dfs(neighbour, dependencies);
            } else if (colors[neighbour] == GRAY) {
                canBeSolved = false;
            }
        }

        topologicalSort.add(course);
        colors[course] = BLACK;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int src = prerequisite[1];
            int dest = prerequisite[0];
            List<Integer> list = dependencies.getOrDefault(src, new ArrayList<>());
            if (!list.contains(dest)) {
                list.add(dest);
            }
            dependencies.put(src, list);
        }
        return dependencies;
    }
}
