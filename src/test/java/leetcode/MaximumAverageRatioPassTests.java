package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaximumAverageRatioPassTests {
    @Test
    public void test() {
        MaximumAverageRatioPass ma = new MaximumAverageRatioPass();

        int[][] classes = {{1,2},{3,5},{2,2}};

        Assertions.assertThat(ma.maxAverageRatio(classes, 2)).isEqualTo(0.7833333333333333);
    }
}
