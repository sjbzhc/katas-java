package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {
    @Test
    public void binary_search() {
        BinarySearch bs = new BinarySearch();
        int[] nums = new int[]{-1,0,3,5,9,12};
        Assertions.assertThat(bs.search(nums, 9)).isEqualTo(4);
    }

    @Test
    public void binary_search_fail() {
        BinarySearch bs = new BinarySearch();
        int[] nums = new int[]{-1,0,3,5,9,12};
        Assertions.assertThat(bs.search(nums, 2)).isEqualTo(-1);
    }
}
