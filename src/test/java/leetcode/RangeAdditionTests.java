package leetcode;


import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RangeAdditionTests {
    @Test
    public void range_addition() {
        RangeAddition rangeAddition = new RangeAddition();
        int[] m1 = {2,4,6};
        int[] m2 = {5,6,8};
        int[] m3 = {1,9,-4};
        int[][] updates = {m1, m2, m3};

        int[] expected = {0,-4,2,2,2,4,4,-4,-4,-4};
        Assertions.assertThat(rangeAddition.getModifiedArray(10, updates)).isEqualTo(expected);
    }

    @Test
    public void range_addition_caching() {
        RangeAddition rangeAddition = new RangeAddition();
        int[] m1 = {2,4,6};
        int[] m2 = {5,6,8};
        int[] m3 = {1,9,-4};
        int[][] updates = {m1, m2, m3};

        int[] expected = {0,-4,2,2,2,4,4,-4,-4,-4};
        Assertions.assertThat(rangeAddition.getModifiedArrayWithCaching(10, updates)).isEqualTo(expected);
    }

    @Test
    public void range_addition_caching2() {
        RangeAddition2 rangeAddition = new RangeAddition2();
        int[] m1 = {2,4,6};
        int[] m2 = {5,6,8};
        int[] m3 = {1,9,-4};
        int[][] updates = {m1, m2, m3};

        int[] expected = {0,-4,2,2,2,4,4,-4,-4,-4};
        Assertions.assertThat(rangeAddition.getModifiedArrayWithCaching(10, updates)).isEqualTo(expected);
    }
}
