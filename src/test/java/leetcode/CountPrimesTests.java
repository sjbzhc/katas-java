package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CountPrimesTests {
    @Test
    public void test() {
        CountPrimes cp = new CountPrimes();

        Assertions.assertThat(cp.countPrimes(10)).isEqualTo(4);
    }
}
