package leetcode;

import java.util.Arrays;

/*
* Time: O(m log n)
* Space: O(n)
* The trick lies in sorting the array. This way, any new node we encounter, we can add it to the disjoint set without
* having to check if that would make the graph more expensive, as we know it's the cheapest option.
*
* A new pair of nodes, with nodes already connected to the graph, will be skipped, as it does not add any value to the
* graph.
*
* The weights in the disjoint set are used to determine how many components are connected with the current node's parent.
* We want to attach to the one with the highest weight, as it means we increase the graph's size.
*
* At the beginning we have a disjoint set, where all nodes are their own parents. When we do a union, the node with the
* smallest weight get assigned a parent, the one with the higher weight.
*
* This is Kruskal's algorithm
* */

public class ConnectCitiesMinimumCost {

    class UnionFind {
        private int[] root;
        private int[] weights; // stores number of nodes attached to a node, not costs

        public boolean union(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);

            if (rootA == rootB) return false;

            if (weights[a] > weights[b]) {
                root[rootB] = rootA;
                weights[rootA] += weights[rootB];
            } else {
                root[rootB] = rootA;
                weights[rootA] += 1;
            }
            return true;
        }

        // A root element has itself as its parent
        private int findRoot(int a) {
            while (a != root[a]) {
                a = root[a];
            }
            return a;
        }

        public boolean isInSameGroup(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

        public UnionFind(int n) {
            root = new int[n + 1];
            weights = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                root[i] = i;
                weights[i] = 1;
            }
        }
    }

    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int numEdges = 0;
        int cost = 0;

        for (int i=0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];

            if (!uf.union(a, b)) continue;

            uf.union(a, b);
            cost += connections[i][2];
            numEdges++;
        }
        if (numEdges == n-1) return cost;
        return -1;
    }
}
