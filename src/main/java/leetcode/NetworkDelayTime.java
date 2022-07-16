package leetcode;

import java.util.*;

/*
* Time: O(V * E) in complete graph, all nodes are added to all edges
* Space: O(V * E) nodes in queue
* */

public class NetworkDelayTime {

    class Pair {
        int travelTime;
        int destination;

        public Pair(int travelTime, int destination) {
            this.travelTime = travelTime;
            this.destination = destination;
        }
    }

    Map<Integer, List<Pair>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);


        bfs(signalReceivedAt, k);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            // We take max, as each value in signalReceivedAt is the minimum for each node. So max represents
            // the shortest time it took for the longest path
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        // INT_MAX signifies at least one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void bfs(int[] signalReceivedAt, int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceNode);

        // Time for starting node is 0
        signalReceivedAt[sourceNode] = 0;

        while (!q.isEmpty()) {
            int currNode = q.poll();

            if (!adj.containsKey(currNode)) continue;

            // Broadcast the signal to adjacent nodes
            for (Pair neighbor : adj.get(currNode)) {
                int travelTime = neighbor.travelTime;
                int destinationNode = neighbor.destination;

                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time :
                // time when signal reaches neighborNode
                int arrivalTimeToDestination = signalReceivedAt[currNode] + travelTime;
                // always record the smaller value
                if (signalReceivedAt[destinationNode] > arrivalTimeToDestination) {
                    signalReceivedAt[destinationNode] = arrivalTimeToDestination;
                    // if we updated this time, we should re-visit it's neighbors
                    q.add(destinationNode);
                }
            }
        }
    }
}
