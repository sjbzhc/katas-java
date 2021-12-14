package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

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

    public boolean overlap(int[] i1, int[] i2) {
        int[] left = i1[0] <= i2[0] ? i1 : i2;
        int[] right = i1[0] > i2[0] ? i1 : i2;

        if (left[1] >= right[0]) return true;

        return false;
    }
}
