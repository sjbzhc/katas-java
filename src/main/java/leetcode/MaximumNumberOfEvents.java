package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEvents {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int eventsIndex = 0;
        int day = 0;
        int res = 0;

        // Still have events to go in array or still have events in pq
        while (eventsIndex < n || !pq.isEmpty()) {
            // Get current day. Will always come here since we empty the pq after each new day's event is added
            if (pq.isEmpty()) {
                day = events[eventsIndex][0];
            }

            // Add all events starting today
            while (eventsIndex < n && day == events[eventsIndex][0]) {
                pq.add(events[eventsIndex][1]);
                eventsIndex++;
            }

            // Join only the earliest ending event, add to count.
            // Since we can only join 1 event per day, move to next day
            pq.poll();
            res++;
            day++;

            // Remove all events that we cannot join anymore. This should be all events, as we only added to the pq
            // the days with the same date as the previous day
            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
        }

        return res;

    }
}
