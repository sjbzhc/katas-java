package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class DailyTemperaturesTests {
    @Test
    public void test() {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] expected = {1,1,4,2,1,1,0,0};
        Assertions.assertThat(dt.dailyTemperatures(temperatures)).isEqualTo(expected);
    }
}
