package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NumberOf1BitsTests {
    @Test
    public void test() {
        NumberOf1Bits nB = new NumberOf1Bits();

        Assertions.assertThat(nB.hammingWeight(00000000000000000000000000001011)).isEqualTo(3);
    }
}
