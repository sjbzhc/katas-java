package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class MaximumSplitOfPositiveEvenIntegersTests {
    @Test
    public void test() {
        MaximumSplitOfPositiveEvenIntegers mn = new MaximumSplitOfPositiveEvenIntegers();

        List<Long> res = List.of(2L, 4L, 6L, 16L);

        Assertions.assertThat(mn.maximumEvenSplit(28)).isEqualTo(res);
    }
}
