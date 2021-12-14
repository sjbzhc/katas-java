package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumCostToConnectSticksTests {
    @Test
    public void min_cost_connect_sticks() {
        MinimumCostToConnectSticks mc = new MinimumCostToConnectSticks();
        int[] sticks = {2,4,3};

        Assertions.assertThat(mc.connectSticks(sticks)).isEqualTo(14);
    }

    @Test
    public void min_cost_connect_sticks_2() {
        MinimumCostToConnectSticks mc = new MinimumCostToConnectSticks();
        int[] sticks = {1,8,3,5};

        Assertions.assertThat(mc.connectSticks(sticks)).isEqualTo(30);
    }

    @Test
    public void min_cost_connect_sticks_2_2() {
        MinimumCostToConnectSticks2 mc = new MinimumCostToConnectSticks2();
        int[] sticks = {2,4,3};

        Assertions.assertThat(mc.connectSticks(sticks)).isEqualTo(14);
    }
}
