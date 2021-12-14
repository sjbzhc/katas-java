package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEvents2 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int day = 0;
        int eventIndex = 0;

        while (eventIndex < events.length || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[eventIndex][0];
            }

            while (eventIndex < events.length && events[eventIndex][0] == day) {
                pq.add(events[eventIndex][1]);
                eventIndex++;
            }

            pq.poll();
            res++;
            day++;

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }

        return res;
    }
}
