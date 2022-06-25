package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClimbingStairsTests {
    @Test
    public void climbing_stairs() {
        ClimbingStairs cs = new ClimbingStairs();

        Assertions.assertThat(cs.climbStairs(3)).isEqualTo(3);
        Assertions.assertThat(cs.climbStairsDP(3)).isEqualTo(3);
    }
}
