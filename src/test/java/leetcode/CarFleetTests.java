package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarFleetTests {
    @Test
    public void test() {
        CarFleet cf = new CarFleet();
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        Assertions.assertThat(cf.carFleet(12, position, speed)).isEqualTo(3);
    }
}
