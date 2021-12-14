package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int i) {
//        Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        Arrays.sort(points, (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] +b[1]*b[1]));

        return Arrays.copyOf(points, i);
    }
}
