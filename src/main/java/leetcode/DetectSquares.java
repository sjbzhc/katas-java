package leetcode;

import java.util.*;

/*
* Time: O(n)
* Space: O(n)
* */

public class DetectSquares {

    Map<String, Integer> count;
    List<int[]> points;
    public DetectSquares() {
        count = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = "#" + point[0] + "#" + point[1];
        count.put(key, count.getOrDefault(key, 0) + 1);
        points.add(point);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];

        int res = 0;

        for (int[] p : points) {
            if (Math.abs(px - p[0]) != Math.abs(py - p[1]) || Math.abs(px - p[0]) == 0 || Math.abs(py - p[1]) == 0) continue;
            String c1 = "#" + px + "#" + p[1];
            String c2 = "#" + p[0] + "#" + py;
            // since we identified a diagonal, the counter-diagonal points follow from the combination of the
            // points of the diagonal
            res += count.getOrDefault(c1, 0) * count.getOrDefault(c2, 0);
        }
        return res;
    }
}
