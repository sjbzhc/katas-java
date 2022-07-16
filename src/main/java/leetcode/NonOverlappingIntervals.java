package leetcode;

import java.util.Arrays;

/*
* Time: O(n log n)
* Space: O(1)
* */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int res = 0;
        int prevEnd = intervals[0][1];

        for (int i=1; i<intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[0];
            // no overlap
            if (start >= prevEnd) prevEnd = end;
            else {
                res++;
                // We remove the one with the largest end, as we don't know if another collision could be
                // in the space smallerEnd -> largerEnd
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return res;
    }
}
