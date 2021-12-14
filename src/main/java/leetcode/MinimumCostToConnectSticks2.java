package leetcode;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks2 {
    public int connectSticks(int[] sticks) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int stick : sticks) {
            pq.add(stick);
        }

        while (pq.size() >= 2) {
            int current = pq.poll() + pq.poll();
            result += current;
            pq.add(current);
        }

        return result;
    }
}
