package leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* Time: O(n)
* Space: O(n)
* */

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();

        for (int i=0; i<intervals.length; i++) {
            int[] interval = intervals[i];

            if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.addAll(Arrays.asList(Arrays.copyOfRange(intervals, i, interval.length)));
                return res.toArray(new int[res.size()][]);
            }
            // We can assume that all intervals with an ending time greater than the start of the new interval
            // have already been added, since by being sorted according to start time, all previous intervals
            // had even smaller values
            else if (newInterval[0] > interval[1]) {
                res.add(intervals[i]);
            }
            else {
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
