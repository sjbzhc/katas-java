package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    /*
    * Time: O(n log n) nlogn sorting
    * Space: O(n)
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
    * The else case implied that the end element last added is bigger than the current start (e.g. (1,3) and (2, 6)),
    * which means they can be merged.
    * */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public boolean overlap(int[] i1, int[] i2) {
        int[] left = i1[0] <= i2[0] ? i1 : i2;
        int[] right = i1[0] > i2[0] ? i1 : i2;

        if (left[1] >= right[0]) return true;

        return false;
    }
}
