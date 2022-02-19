package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class KClosestPointsTests {
    @Test
    public void k_closest() {
        KClosestPoints kp = new KClosestPoints();
        int[] p1 = {1,3};
        int[] p2 = {-2,2};
        int[][] points = {p1, p2};

        int[][] expected = {p2};

        Assertions.assertThat(kp.kClosest(points, 1)).isEqualTo(expected);
    }

    @Test
    public void k_closest_pq() {
        KClosestPoints kp = new KClosestPoints();
        int[] p1 = {1,3};
        int[] p2 = {-2,2};
        int[][] points = {p1, p2};

        int[][] expected = {p2};

        Assertions.assertThat(kp.kClosestPq(points, 1)).isEqualTo(expected);
    }

    @Test
    public void k_closest_pq_2() {
        KClosestPoints kp = new KClosestPoints();
        int[] p1 = {3,3};
        int[] p2 = {5,-1};
        int[] p3 = {-2,4};
        int[][] points = {p1, p2, p3};

        int[][] expected = {p1, p3};

        Assertions.assertThat(kp.kClosestPq(points, 2)).isEqualTo(expected);
    }
}

