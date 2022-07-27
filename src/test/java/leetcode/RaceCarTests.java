package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RaceCarTests {
    @Test
    public void test() {
        RaceCar rc = new RaceCar();

        Assertions.assertThat(rc.racecar(3)).isEqualTo(2);
    }
}
