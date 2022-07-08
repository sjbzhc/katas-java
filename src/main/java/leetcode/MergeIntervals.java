package leetcode;

import java.util.*;

public class MergeIntervals {

    /*
    *
    * (1,3), (2,6) can be merged
    *
    * (1,3), (4,6) cannot be merged
    *
    *
    * We start the merged array with the first interval.
    * Since the intervals are always (start=min, end=max), we can focus only on the end values.
    *
    * If the end element added last to the array is smaller than the current start (e.g. (1,3) and (4,6)), it means
    * that the intervals cannot be merged.
    *
    * The else case implies that the last added interval's end is bigger than the current start (e.g. (1,3) and (2, 6)),
    * which means they can be merged.
    *
    * Time: O(n log n) nlogn sorting
    * Space: O(n)
    * */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (merged.isEmpty() || merged.getLast()[1] < start) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], end);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            int[] interval = intervals[i];
            if (!stack.isEmpty() && stack.peek()[0] <= interval[0] && stack.peek()[1] >= interval[0]) {
                int[] current = stack.pop();
                int[] newInterval = new int[]{
                        Math.min(current[0], interval[0]),
                        Math.max(current[1], interval[1])
                };
                stack.push(newInterval);
            } else {
                stack.push(interval);
            }
        }
        int[][] res = new int[stack.size()][2];

        for (int i=0; i<res.length; i++) {
            res[i] = stack.get(i);
        }
        return res;
    }

    public boolean overlap(int[] i1, int[] i2) {
        int[] left = i1[0] <= i2[0] ? i1 : i2;
        int[] right = i1[0] > i2[0] ? i1 : i2;

        if (left[1] >= right[0]) return true;

        return false;
    }
}
