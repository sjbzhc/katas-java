package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class DecodeWaysTests {
    @Test
    public void test() {
        DecodeWays dw = new DecodeWays();

        Assertions.assertThat(dw.numDecodings("226")).isEqualTo(3);
    }
}
