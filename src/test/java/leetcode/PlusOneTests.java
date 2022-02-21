package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PlusOneTests {
    @Test
    public void plus_one() {
        PlusOne po = new PlusOne();
        int[] arr = {1,2,3};
        int[] expected = {1,2,4};

        Assertions.assertThat(po.plusOne(arr)).isEqualTo(expected);
    }

    @Test
    public void plus_one_2() {
        PlusOne po = new PlusOne();
        int[] arr = {9,9,9};
        int[] expected = {1,0,0,0};

        Assertions.assertThat(po.plusOne(arr)).isEqualTo(expected);
    }
}
