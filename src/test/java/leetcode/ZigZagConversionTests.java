package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ZigZagConversionTests {
    @Test
    public void test() {
        ZigZagConversion zz = new ZigZagConversion();

        Assertions.assertThat(zz.convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
    }
}
