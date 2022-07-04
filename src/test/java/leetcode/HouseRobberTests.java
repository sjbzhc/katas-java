package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class HouseRobberTests {
    @Test
    public void test() {
        HouseRobber hr = new HouseRobber();
        int[] nums = {1,2,3,1};

        Assertions.assertThat(hr.rob(nums)).isEqualTo(4);
    }
}
