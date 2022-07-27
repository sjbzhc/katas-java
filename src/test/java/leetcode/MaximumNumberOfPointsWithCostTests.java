package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaximumNumberOfPointsWithCostTests {
    @Test
    public void test() {
        MaximumNumberOfPointsWithCost mn = new MaximumNumberOfPointsWithCost();

        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};

        Assertions.assertThat(mn.maxPoints(points)).isEqualTo(9);
    }
}
