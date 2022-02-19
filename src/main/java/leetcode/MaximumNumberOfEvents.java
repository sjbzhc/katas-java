package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
* Time: O(n log n)
* Space: O(n)
*
* Sort by starting day
* Add to pq the end-dates of all events that start today
* Remove the first element from pq. This corresponds to the ending time of the event that ends earliest (since its a min heap)
* Increase day and count by one
* Remove all other events from the heap, where the value is smaller that the now increased day
*
*
* */

public class MaximumNumberOfEvents {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int eventsIndex = 0;
        int day = events[eventsIndex][0];
        int res = 0;

        // Still have events to go in array or still have events in pq
        while (eventsIndex < n) {

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
