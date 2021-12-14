package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedule2 {
    int WHITE = 0;
    int GRAY = 2;
    int BLACK = 3;
    boolean isPossible = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        int[] colors = new int[numCourses];

        for (int i =0; i < numCourses; i++) {
            if (colors[i] == WHITE) {
                dfs(i, list, colors, graph);
            }
        }

        if (!isPossible) {
            return new int[0];
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }

    private void dfs(int course, List<Integer> list, int[] colors, Map<Integer, List<Integer>> graph) {
        if (!isPossible) {
            return;
        }

        colors[course] = GRAY;

        for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if (colors[neighbor] == WHITE) {
                dfs(neighbor, list, colors, graph);
            }
            if (colors[neighbor] == GRAY) {
                isPossible = false;
            }
        }

        list.add(course);
        colors[course] = BLACK;

    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int requisite = prerequisite[1];
            int course = prerequisite[0];
            result.getOrDefault(course, new ArrayList<>()).add(requisite);
        }
        return result;
    }
}
