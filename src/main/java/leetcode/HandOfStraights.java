package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* Time: O(n log n)
* Space: O(n)
* */

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();

        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : count.keySet()) pq.offer(n);

        while (!pq.isEmpty()) {
            int first = pq.peek();

            // Since we wnt consecutive numbers, i starting from first to groupSize should always be present
            for (int i=first; i<first + groupSize; i++) {
                if (!count.containsKey(i)) return false;

                 count.put(i, count.get(i) - 1);

                 // if the count is 0 we need to pop it from pq
                // If the value we are about to pop is not the top of the heap return false, as we have a smaller number
                // and we should be building the heap with increasing values from the pq
                if (count.get(i) == 0) {
                    if (i != pq.peek()) return false;
                    pq.poll();
                }
            }
        }
        return true;
    }
}
