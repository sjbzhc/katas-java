package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Time: O(n2)
* Space: O(n)
*
* We use sliding window. End and start represent indices of the list of angles.
*   End is increased until the difference between angles[end] - angles[start] is smaller than angle.
*   Start is increased as soon as we cannot increase end further. For the new start index, the max end is again calculated.
* Handle circular using modulo.
* */
public class VisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int overlap = 0;
        List<Double> list = new ArrayList<>();

        for (List<Integer> p : points) {
            if (p.get(0) == location.get(0) && p.get(1) == location.get(1)) overlap++;
             else list.add(angle(p.get(1) - location.get(1), p.get(0) - location.get(0)));
        }

        Collections.sort(list);
        int max = 0;
        int n = list.size();
        int end = 0;
        for (int start = 0; start < n; start++) {
            /*
            * edge case: start > end:
            *   for end, pick the next element in circular cycle + 360
            * */
            while ((end < n && list.get(end) - list.get(start) <= angle) ||
                    (end >= n && 360 + list.get(end % n) - list.get(start) <= angle)) {
                end++;
            }
            max = Math.max(max, end - start);
        }
        return max + overlap;
    }

    private double angle(int dy, int dx) {
        double a = Math.toDegrees(Math.atan2(dy, dx));
        return (a < 0 ? a + 360 : a);
    }
}
