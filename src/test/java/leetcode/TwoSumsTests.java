package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TwoSumsTests {

    @Test
    public void two_sums() {
        int[] expected = {1, 0};
        Assertions.assertThat(TwoSums.twoSum(new int[]{2, 7, 11, 15}, 9)).isEqualTo(expected);
    }
}
