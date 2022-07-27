package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Time: O(n log n)
* Space: O(n)
* */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        for (String t : timePoints) {
            String[] timePoint = t.split(":");
            minutes.add(Integer.parseInt(timePoint[0]) * 60 + Integer.parseInt(timePoint[1]));
        }

        Collections.sort(minutes);

        int res = Integer.MAX_VALUE;

        for (int i=1; i<minutes.size(); i++) {
            int diff = minutes.get(i) - minutes.get(i-1);
            res = Math.min(res, diff);
        }

        // Take max possible time, subtract the last time and add the offset of the first time
        int roundCheck = 24 * 60 - minutes.get(minutes.size() - 1) + minutes.get(0);

        return Math.min(res, roundCheck);
    }
}
