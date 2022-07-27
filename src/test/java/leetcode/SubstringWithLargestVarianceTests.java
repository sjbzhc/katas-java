package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SubstringWithLargestVarianceTests {
    @Test
    public void test() {
        SubstringWithLargestVariance sw = new SubstringWithLargestVariance();

        Assertions.assertThat(sw.largestVariance("aababbb")).isEqualTo(3);
    }
}
