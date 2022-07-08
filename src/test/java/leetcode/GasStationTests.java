package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class GasStationTests {
    @Test
    public void test() {
        GasStation gs = new GasStation();

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Assertions.assertThat(gs.canCompleteCircuit(gas, cost)).isEqualTo(3);
    }
}
