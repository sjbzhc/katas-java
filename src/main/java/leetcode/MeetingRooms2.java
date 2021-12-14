package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRoomsPriorityQueue(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, comparator);
        pq.add(intervals[0][1]);
        for (int i=1;i<intervals.length;i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
