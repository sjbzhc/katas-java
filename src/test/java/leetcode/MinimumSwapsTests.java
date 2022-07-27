package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumSwapsTests {
    @Test
    public void test() {
        MinimumSwaps ms = new MinimumSwaps();

        int[] nums = {3, 1, 5, 3, 5, 5, 2};
        Assertions.assertThat(ms.minSwaps(nums)).isEqualTo(6);
    }
}
