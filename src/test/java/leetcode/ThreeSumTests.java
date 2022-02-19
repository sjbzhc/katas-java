package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class ThreeSumTests {
    @Test
    public void three_sum() {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> res = List.of(List.of(-1,-1,2), List.of(-1,0,1));

        Assertions.assertThat(ts.threeSum(nums)).isEqualTo(res);
    }
}
