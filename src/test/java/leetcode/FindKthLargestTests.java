package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FindKthLargestTests {
    @Test
    public void find_k_largest() {
        FindKthLargest fk = new FindKthLargest();
        int[] nums = {3,2,1,5,6,4};

        Assertions.assertThat(fk.findKthLargest(nums, 2)).isEqualTo(5);
    }
}
