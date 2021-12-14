package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals2 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] head = result.getFirst();
            int lower = head[0];
            int upper = head[1];
            if (upper > intervals[i][0]) {
                head[1] = intervals[i][1];
            } else {
                result.add(intervals[i]);
            }
        }
        int[][] res = new int[result.size()][];
        var ref = new Object() {
            int index = 0;
        };
        result.stream().forEach(e -> {
            res[ref.index] = e;
            ref.index++;
        });

//        return result.toArray(new int[result.size()][]);
        return res;
    }
}
