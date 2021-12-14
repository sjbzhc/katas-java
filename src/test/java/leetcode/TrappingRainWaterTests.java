package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TrappingRainWaterTests {
    @Test
    public void trapping_rainwater() {
        TrappingRainWater tr = new TrappingRainWater();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        Assertions.assertThat(tr.trapBrutForce(heights)).isEqualTo(6);
    }

    @Test
    public void trapping_rainwater_dp() {
        TrappingRainWater tr = new TrappingRainWater();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        Assertions.assertThat(tr.trapDynamicProgramming(heights)).isEqualTo(6);
    }

    @Test
    public void trapping_rainwater_2() {
        TrappingRainWater2 tr = new TrappingRainWater2();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        Assertions.assertThat(tr.trapDynamicProgramming(heights)).isEqualTo(6);
    }
}
