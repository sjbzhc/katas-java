package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PowTests {
    @Test
    public void test() {
        Pow p = new Pow();

        Assertions.assertThat(p.myPow(2.0, 10)).isEqualTo(1024.0);
    }
}
