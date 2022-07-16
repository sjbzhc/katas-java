package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class LargestRectangleAreaTests {
    @Test
    public void test() {
        LargestRectangleArea lr = new LargestRectangleArea();

        int[] heights = new int[]{2,1,5,6,2,3};

        Assertions.assertThat(lr.largestRectangleArea(heights)).isEqualTo(10);
    }
}
