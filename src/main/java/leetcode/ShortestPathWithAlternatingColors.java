package leetcode;

import java.util.*;

/*
* Time: O(n)
* Space: O(n)
* */

public class ShortestPathWithAlternatingColors {

    class Pair {
        int node;
        int color;

        public Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return node == pair.node && color == pair.color;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, color);
        }
    }

    int RED = 0;
    int BLUE = 1;


    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redGraph = new HashMap<>();
        Map<Integer, List<Integer>> blueGraph = new HashMap<>();
        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            redGraph.put(i, new ArrayList<>());
            blueGraph.put(i, new ArrayList<>());
        }
        // Graph initialization
        for (int[] redEdge : redEdges) {
            int parent = redEdge[0];
            int child = redEdge[1];
            redGraph.get(parent).add(child);
        }
        for (int[] blueEdge : blueEdges) {
            int parent = blueEdge[0];
            int child = blueEdge[1];
            blueGraph.get(parent).add(child);
        }

        int steps = 0;
        Queue<Pair> q = new LinkedList<>();
        // pair of node and current color edge taken to arrive
        q.add(new Pair(0, RED));
        q.add(new Pair(0, BLUE));
        Set<Pair> seen = new HashSet<>();
        // Perform BFS starting from 0th node. Add two pairs since we have simulate starting from red or blue edge
        // since bfs finds the shortest path, update the steps taken so far when arriving at any node
        // Each step add neighboring nodes from the opposite color
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                size--;
                Pair cur = q.poll();
                seen.add(cur);
                int curNode = cur.node;
                int color = cur.color;
                shortestPath[curNode] = Math.min(shortestPath[curNode], steps);
                if (color == RED) {
                    for (int child : blueGraph.get(curNode)) {
                        Pair newPair = new Pair(child, BLUE);
                        if (!seen.contains(newPair)) q.add(newPair);
                    }
                } else {
                    for (int child : redGraph.get(curNode)) {
                        Pair newPair = new Pair(child, RED);
                        if (!seen.contains(newPair)) q.add(newPair);
                    }
                }
            }
            steps++;
        }
        for (int i = 0; i < shortestPath.length; i++) {
            if (shortestPath[i] == Integer.MAX_VALUE) {
                shortestPath[i] = -1;
            }
        }
        return shortestPath;
    }
}
