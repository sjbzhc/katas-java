package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Time: O(n log n)
* Space: O(n)
* */

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(sticks.length, comparator);
        int result = 0;

        for (int stick : sticks) {
            pq.add(stick);
        }

        while (pq.size() >= 2) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            int newMin = min1 + min2;
            result += newMin;
            pq.add(newMin);
        }

        return result;
    }
}
