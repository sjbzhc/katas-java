package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FindMinimumInRotatedSortedArrayTests {
    @Test
    public void test() {
        FindMinimumInRotatedSortedArray fm = new FindMinimumInRotatedSortedArray();

        int[] nums = {4,5,6,7,0,1,2};

        Assertions.assertThat(fm.findMin(nums)).isEqualTo(0);
    }
}
