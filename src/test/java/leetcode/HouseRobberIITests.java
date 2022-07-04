package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class HouseRobberIITests {
    @Test
    public void test() {
        HouseRobberII hr = new HouseRobberII();
        int[] nums = {2,3,2};
        Assertions.assertThat(hr.rob(nums)).isEqualTo(3);

    }
}
