package leetcode;

/*
* Time: O(n)
* Space: O(n)
* */
public class GraphValidTree {

    private class UnionFind {
        int[] root;
        public UnionFind(int size) {
            root = new int[size];
            for (int i=0; i< size; i++) {
                root[i] = i;
            }
        }

        public int find(int n) {
            while (root[n] != n) {
                n = root[n];
            }
            return n;
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return false;

            root[rootB] = root[rootA];
            return true;
        }

    }

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);

        for (int [] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!uf.union(a, b)) return false;
        }

        return true;
    }
}
