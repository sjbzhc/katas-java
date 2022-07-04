package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinCostToConnectAllPointsTests {
    @Test
    public void test() {
        MinCostToConnectAllPoints mc = new MinCostToConnectAllPoints();

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        Assertions.assertThat(mc.minCostConnectPoints(points)).isEqualTo(20);
    }

    @Test
    public void test_MST() {
        MinCostToConnectAllPoints mc = new MinCostToConnectAllPoints();

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        Assertions.assertThat(mc.minCostConnectPointsMST(points)).isEqualTo(20);
    }
}
