package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BurstBalloonsTests {
    @Test
    public void test() {
        BurstBalloons bb = new BurstBalloons();

        int[] nums = {3,1,5,8};

        Assertions.assertThat(bb.maxCoins(nums)).isEqualTo(167);
    }
}
