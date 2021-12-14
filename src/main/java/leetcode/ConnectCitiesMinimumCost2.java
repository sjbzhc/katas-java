package leetcode;

import java.util.Arrays;

public class ConnectCitiesMinimumCost2 {

    class DisjointSet {
        private int[] parents;
        private int[] weights;

        public void union(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);

            if (rootA == rootB) return;

            if (weights[a] > weights[b]) {
                parents[rootB] = rootA;
                weights[rootA] += weights[rootB];
            } else {
                parents[rootA] = rootB;
                weights[rootB] += weights[rootA];
            }
        }

        private int findRoot(int a) {
            while (parents[a] != a) {
                a = parents[a];
            }
            return a;
        }

        public boolean isInSameGroup(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

        public DisjointSet(int n) {
            parents = new int[n + 1];
            weights = new int[n + 1];
            for (int i=1; i<=n; i++) {
                parents[i] = i;
                weights[i] = 1;
            }
        }
    }
    public int minimumCost(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int numEdges = 0;
        int cost = 0;

        for (int i=0;i<connections.length;i++) {
            int a = connections[i][0];
            int b = connections[i][1];

            if (ds.isInSameGroup(a, b)) continue;

            ds.union(a, b);
            cost += connections[i][2];
            numEdges++;
        }

        if (numEdges == n-1) return cost;
        return -1;
    }
}
