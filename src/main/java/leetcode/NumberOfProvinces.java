package leetcode;

import java.util.*;

/*
* Time: O(n^2)
* Space: O(n)
* */

public class NumberOfProvinces {
    int WHITE = 0;
    int BLACK = 1;
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0) return 0;
        int n = isConnected.length;

        int[] colors = new int[n];

        Map<Integer, Set<Integer>> adjacencyLists = init(n);
        createGraph(isConnected, adjacencyLists);

        int count = 0;

        for (int i=0;i<n;i++) {
            if (colors[i] == WHITE) {
                count++;
                dfs(adjacencyLists, i, colors);
            }
        }


        return count;
    }

    private void dfs(Map<Integer, Set<Integer>> adjacencyLists, int city, int[] colors) {
        if (colors[city] != WHITE) return;

        colors[city] = BLACK;

        Set<Integer> neighbors = adjacencyLists.get(city);

        for (int n : neighbors) {
            dfs(adjacencyLists, n, colors);
        }

    }

    private void createGraph(int[][] isConnected, Map<Integer, Set<Integer>> adjacencyLists) {
        int n = isConnected.length;
        for (int i=0; i<n;i++) {
            for (int j=0; j<n;j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjacencyLists.get(i).add(j);
                    adjacencyLists.get(j).add(i);
                }
            }
        }
    }

    private Map<Integer, Set<Integer>> init(int n) {
        Map<Integer, Set<Integer>> adjacencyLists = new HashMap<>();
        for (int i = 0; i< n; i++) {
            adjacencyLists.put(i, new HashSet<>());
        }
        return adjacencyLists;
    }


    public int findCircleNumSimple(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i=0;i<isConnected.length;i++) {
            if (visited[i] == 0) {
                count++;
                dfs2(isConnected, visited, i);
            }
        }


        return count;
    }

    private void dfs2(int[][] isConnected, int[] visited, int i) {
        for(int j=0;j<isConnected.length;j++) {
            if(isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs2(isConnected, visited, j);
            }
        }
    }


}
