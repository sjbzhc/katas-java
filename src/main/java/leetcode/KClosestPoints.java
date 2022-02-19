package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Time: O(n log n)
* Space: O(n)
* */

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int i) {
//        Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        Arrays.sort(points, (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] +b[1]*b[1]));

        return Arrays.copyOf(points, i);
    }

    public int[][] kClosestPq(int[][] points, int i) {
        Comparator<int[]> comp = (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(i, comp);
        for (int[] point : points) {
            pq.add(point);
        }

        int[][] result = new int[i][2];

        for (int j=0; j<i; j++) {
            result[j] = pq.poll();
        }
        return result;
    }
}
