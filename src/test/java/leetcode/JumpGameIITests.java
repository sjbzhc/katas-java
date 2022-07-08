package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class JumpGameIITests {
    @Test
    public void test() {
        JumpGameII jg = new JumpGameII();

        int[] nums = {2,3,1,1,4};

        Assertions.assertThat(jg.jump(nums)).isEqualTo(2);
    }
}
