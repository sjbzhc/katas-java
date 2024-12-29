package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


/*
* Time: O(n2 log n)
* Space: O(n2)
*
* Kruskal's Algorithm to fins the Minimum Spanning Tree in an undirected graph. It selects the edges with the minimum
* weight (sort increasing) and ensures no cycles are formed (union find).
* */
public class MinCostToConnectAllPoints {

    class UnionFind {
        public int[] root;
        public int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; ++i) {
                root[i] = i;
            }
        }

        public int find(int n) {
            while (n != root[n]) {
                n = root[n];
            }
            return n;
        }

        public boolean union(int node1, int node2) {
            int rootA = find(node1);
            int rootB = find(node2);

            if (rootA == rootB) return false;

            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            } else {
                root[rootB] = rootA;
                rank[rootA] += 1;
            }

            return true;
        }
    }

    class Edge {
        int origin;
        int destination;
        int weight;

        public Edge(int origin, int destination, int weight) {
            this.origin = origin;
            this.destination = destination;
            this.weight = weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        // Storing all edges of our complete graph.
        for (int p1 = 0; p1 < n; p1++) {
            for (int p2 = p1 + 1; p2 < n; p2++) {
                int weight = Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);
                edges.add(new Edge(p1, p2, weight));
            }
        }

        // Sort ascendingly
        Collections.sort(edges, (a, b) -> Integer.compare(a.weight, b.weight));

        UnionFind uf = new UnionFind(n);
        int mstCost = 0;

        for (Edge edge: edges) {
            int node1 = edge.origin;
            int node2 = edge.destination;
            int weight = edge.weight;
            if (uf.union(node1, node2)) mstCost += weight;
        }

        return mstCost;
    }

    class Pair {
        int weight;
        int node;

        public Pair(int weight, int currentNode) {
            this.weight = weight;
            this.node = currentNode;
        }
    }

    /*
    * Prim's algorithm. Greedy, on a random node, add the smallest edge (PriorityQueue) and continue until the MST is
    * created (edgesUsed < n).
    * */
    public int minCostConnectPointsMST(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> (a.weight - b.weight));;
        boolean[] visited = new boolean[n];

        heap.add(new Pair(0, 0));
        int cost = 0;
        int edgesUsed = 0;

        while (edgesUsed < n) {
            Pair current = heap.poll();

            int weight = current.weight;
            int currentNode = current.node;

            if (visited[currentNode]) continue;

            visited[currentNode] = true;
            cost += weight;
            edgesUsed++;

            for (int nextNode = 0; nextNode < n; ++nextNode) {
                if (!visited[nextNode]) {
                    int nextWeight = Math.abs(points[currentNode][0] - points[nextNode][0]) +
                            Math.abs(points[currentNode][1] - points[nextNode][1]);

                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
        }

        return cost;
    }
}
