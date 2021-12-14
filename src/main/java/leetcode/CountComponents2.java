package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountComponents2 {
    public int countComponents(int n, int[][] edges) {
        int[] visited = new int[n];
        int count = 0;
        Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();

        createAdjacencyLists(edges, adjacencyLists);

        for (int i=0;i<n;i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adjacencyLists, visited);
            }
        }
        return count;
    }

    private void dfs(int i, Map<Integer, List<Integer>> adjacencyLists, int[] visited) {
        if (visited[i] == 1) return;

        visited[i] = 1;

        for (int e : adjacencyLists.getOrDefault(i, new ArrayList<>())) {
            dfs(e, adjacencyLists, visited);
        }
    }

    private void createAdjacencyLists(int[][] edges, Map<Integer, List<Integer>> adjacencyLists) {
        for (int[] edge : edges) {
            List<Integer> al1 = adjacencyLists.getOrDefault(edge[0], new ArrayList<>());
            al1.add(edge[1]);
            adjacencyLists.put(edge[0], al1);

            List<Integer> al2 = adjacencyLists.getOrDefault(edge[1], new ArrayList<>());
            al2.add(edge[0]);
            adjacencyLists.put(edge[1], al2);

        }
    }
}
