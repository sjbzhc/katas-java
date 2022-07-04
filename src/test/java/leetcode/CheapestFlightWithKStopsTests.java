package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheapestFlightWithKStopsTests {
    @Test
    public void test() {
        CheapestFlightWithKStops cf = new CheapestFlightWithKStops();
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

        Assertions.assertThat(cf.findCheapestPrice(4, flights, 0, 3, 1)).isEqualTo(700);
    }
}
