package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaximumSubarrayMinProductTests {
    @Test
    public void test() {
        MaximumSubarrayMinProduct ms = new MaximumSubarrayMinProduct();

        int[] nums = {1,2,3,2};

        Assertions.assertThat(ms.maxSumMinProduct(nums)).isEqualTo(14);
    }
}
