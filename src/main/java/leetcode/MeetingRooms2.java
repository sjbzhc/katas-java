package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRoomsPriorityQueue(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Comparator is for a min-heap, as we are ordering ascending.
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        pq.add(intervals[0][1]);

        for (int i=1; i< intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];

            int earlieastEnding = pq.peek();

            if (start >= earlieastEnding) pq.poll();
            pq.add(end);
        }
        return pq.size();
    }
}
