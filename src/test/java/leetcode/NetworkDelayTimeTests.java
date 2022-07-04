package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NetworkDelayTimeTests {
    @Test
    public void test() {
        NetworkDelayTime nd = new NetworkDelayTime();

        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};

        Assertions.assertThat(nd.networkDelayTime(times, 4, 2)).isEqualTo(2);
    }
}
