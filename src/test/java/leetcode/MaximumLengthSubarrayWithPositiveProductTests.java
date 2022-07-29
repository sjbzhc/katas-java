package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaximumLengthSubarrayWithPositiveProductTests {
    @Test
    public void test() {
        MaximumLengthSubarrayWithPositiveProduct ml = new MaximumLengthSubarrayWithPositiveProduct();

        int[] nums = {1,-2,-3,4};

        Assertions.assertThat(ml.getMaxLen(nums)).isEqualTo(4);
    }
}
