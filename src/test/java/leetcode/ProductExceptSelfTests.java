package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ProductExceptSelfTests {
    @Test
    public void test() {
        ProductExceptSelf pe = new ProductExceptSelf();
        int[] nums = {1,2,3,4};
        int[] expected = {24,12,8,6};

        Assertions.assertThat(pe.productExceptSelf(nums)).isEqualTo(expected);
    }

    @Test
    public void test_constant_memory() {
        ProductExceptSelf pe = new ProductExceptSelf();
        int[] nums = {1,2,3,4};
        int[] expected = {24,12,8,6};

        Assertions.assertThat(pe.productExceptSelfConstantMemory(nums)).isEqualTo(expected);
    }
}
