package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SlidingWindowMaximumTests {
    @Test
    public void sliding_window() {
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] expected = {3,3,5,5,6,7};
        Assertions.assertThat(sw.maxSlidingWindow(nums, 3)).isEqualTo(expected);
    }

    @Test
    public void sliding_window_2() {
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3};
        int[] expected = {3,3};
        Assertions.assertThat(sw.maxSlidingWindow(nums, 3)).isEqualTo(expected);
    }

    @Test
    public void sliding_window_pq() {
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] expected = {3,3,5,5,6,7};
        Assertions.assertThat(sw.maxSlidingWindowPQ(nums, 3)).isEqualTo(expected);
    }

    @Test
    public void sliding_window_dp() {
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] expected = {3,3,5,5,6,7};
        Assertions.assertThat(sw.maxSlidingWindowDp(nums, 3)).isEqualTo(expected);
    }
}
