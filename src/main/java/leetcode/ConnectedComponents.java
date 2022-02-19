package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(V + E)
* Space: O(V + E)
*
* We use the fact that dfs will go through all the child nodes of a node n, before continuing with n's siblings.
*
* So every time we start dfs with a new node n, we increase the counter.
* In dfs, we mark every node we visit as visited and we only recurse if not visited.
*
* */

public class ConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adjacencyLists = new ArrayList[n];
        int counter = 0;
        int[] visited = new int[n];
        for (int i = 0; i<n;i++) {
            adjacencyLists[i] = new ArrayList<>();
        }

        createGraph(edges, adjacencyLists);

        for (int i=0; i<n; i++) {
            if (visited[i] == 0) {
                counter++;
                dfs(adjacencyLists, i, visited);
            }
        }

        return counter;
    }

    private void dfs(List<Integer>[] adjacencyList, int startNode, int[] visited) {
        visited[startNode] = 1;

        for (int i=0; i< adjacencyList[startNode].size(); i++) {
            if (visited[adjacencyList[startNode].get(i)] == 0) {
                dfs(adjacencyList, adjacencyList[startNode].get(i), visited);
            }
        }
    }

    private void createGraph(int[][] edges, List<Integer>[] adjacencyList) {
        for(int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
    }
}
