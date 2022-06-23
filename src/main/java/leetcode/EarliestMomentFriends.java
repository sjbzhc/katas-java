package leetcode;

import java.util.Arrays;

/*
* Sort timestamps to ensure we find the earliest moment
* Add rank to union find, and if they don't share a root, attach lower ranked to higher one. In case they are the same,
* pick one (e.g. A) and pretend it's the higher one.
* If n goes to 1 we return timestamp
* We don't increase the rank of A if it's greater than B, since they won't be compared anymore in the future, but we could do it
* and it would lead to the same results
* */

/*
* Time: O(n + mlog m + Ma(N)) n create union find, mlogm sorting, Ma(N) iterate through sorted logs (amortized)
* Space: O(N + M) union find + space for sorting
* */

public class EarliestMomentFriends {

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

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            int time = log[0];
            int p1 = log[1];
            int p2 = log[2];

            if (uf.union(p1, p2)) n--;

            if (n == 1) return time;
        }
        return -1;
    }


}
