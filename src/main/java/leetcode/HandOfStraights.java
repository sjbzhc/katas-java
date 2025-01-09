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
        // By having the card values on the pq, we always get the smallest one, which is necessary
        // to build consecutive suits
        for (int n : count.keySet()) pq.offer(n);

        while (!pq.isEmpty()) {
            int first = pq.peek();

            // Since we wnt consecutive numbers, i starting from first to groupSize should always be present
            for (int nextCard=first; nextCard<first + groupSize; nextCard++) {
                if (!count.containsKey(nextCard)) return false;

                 count.put(nextCard, count.get(nextCard) - 1);

                 /*
                 * If the count is 0 we need to pop it from pq
                 * If the nextCard is not the top of pq, that means nextCard is not available, and the sequence
                 * cannot be built
                 * */
                if (count.get(nextCard) == 0) {
                    if (nextCard != pq.peek()) return false;
                    pq.poll();
                }
            }
        }
        return true;
    }
}
