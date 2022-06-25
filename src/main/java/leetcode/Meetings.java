package leetcode;

import java.util.Arrays;

public class Meetings {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        for (int i=1; i< intervals.length; i++) {
            int[] i1 = intervals[i-1];
            int[] i2 = intervals[i];

            if (i1[1] > i2[0]) return false;
        }

        return true;
    }
}
