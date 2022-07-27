package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class MinimumTimeDifferenceTests {
    @Test
    public void test() {
        MinimumTimeDifference mt = new MinimumTimeDifference();

        List<String> list = List.of("23:59","00:00");

        Assertions.assertThat(mt.findMinDifference(list)).isEqualTo(1);
    }
}
