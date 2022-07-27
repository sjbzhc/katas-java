package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;


public class MaximumAreaCakeTests {

    @Test
    public void test() {
        MaximumAreaCake ma = new MaximumAreaCake();

        int[] horizontalCuts = {1,2,4};
        int[] verticalCuts = {1,3};
        int h = 5;
        int w = 4;

        Assertions.assertThat(ma.maxArea(h, w, horizontalCuts, verticalCuts)).isEqualTo(4);
    }
}
