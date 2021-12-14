package leetcode;

import java.util.*;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        List<int[]> meetings = new ArrayList<>();
        meetings.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            if (clashesWithCurrentMeetings(meetings, intervals[i])) {
                meetings.add(intervals[i]);
            }
        }

        return meetings.size();
    }

    private boolean clashesWithCurrentMeetings(List<int[]> meetings, int[] interval) {
        List<Boolean> clashes = new ArrayList<>();
        for (int i=0; i<meetings.size(); i++) {
            int meetingStart = meetings.get(i)[0];
            int meetingEnd = meetings.get(i)[1];
            int intervalStart = interval[0];
            int intervalEnd = interval[1];

            if (
                    (meetingStart < intervalStart && meetingEnd < intervalEnd && meetingEnd > intervalStart)
                    || (meetingStart < intervalStart && meetingEnd > intervalEnd)
                    || (meetingStart < intervalStart && meetingEnd > intervalEnd)
            ) {
                clashes.add(true);
            } else {
                clashes.add(false);
            }
        }
        return clashes.stream().reduce((acc, curr) -> acc && curr).orElseGet(() -> false);
    }

    /*
    * The problem can be solved with a priority queue (as min-heap) and sorting.
    *
    * We first sort the intervals by their starting time.
    *
    * The min-heap keeps the smallest end-time so far seen at the top.
    *
    * If the starting time for our current meeting is greater then the element at the top of the heap, it means
    * one meeting room is free. We can therefore remove this element from the head and update it with the new ending
    * time.
    *
    * If the starting time for our current meeting is smaller than the element at the top of the heap, then we need
    * a new meeting.
    *
    * We can only focus on the starting time of the current meeting because, since we sorted, every meeting that comes
    * after this one will start even later.
    *
    * Example: (1,10), (2,7), (3,19), 8,12)
    * Queue: 10
    * 2 > 10? no -> add 7 to queue
    * Queue: 7, 10
    * 3 > 7? no -> add 19 to queue
    * Queue: 7, 10, 19
    * 8 > 7? yes -> remove 7 from queue, add 12 to queue:
    * Queue: 10, 12, 19
    *
    * */

    public int minMeetingRoomsPriorityQueue(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Comparator is for a min-heap, as we are ordering ascending.
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, comparator);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        allocator.add(intervals[0][1]);

        for (int i=1; i< intervals.length; i++) {

            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
}
