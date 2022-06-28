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


    private class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i=0; i<size;i++) {
                root[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int n) {
            while (n != root[n]) {
                n = root[n];
            }
            return n;
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return false;

            if (rank[rootA] > rank[rootB]) root[rootB] = rootA;
            else if (rank[rootB] > rank[rootA]) root[rootA] = rootB;
            else {
                root[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }
    }

    public int countComponentsUF(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) n--;
        }
        return n;
    }
}
