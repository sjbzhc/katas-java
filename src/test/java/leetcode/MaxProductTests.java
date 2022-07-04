package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaxProductTests {
    @Test
    public void test() {
        MaxProduct mp = new MaxProduct();
        int[] nums = {2,3,-2,4};

        Assertions.assertThat(mp.maxProduct(nums)).isEqualTo(6);
    }
}
