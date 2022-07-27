package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SumCloseToZeroTests {
    @Test
    public void test() {
        SumCloseToZero sc = new SumCloseToZero();

        int a [] = {1, 4, -5, 3, -2, 10, -6, 20};
        int[] res = new int[]{-5, 4};

        Assertions.assertThat(sc.findSum(a)).isEqualTo(res);
    }
}
