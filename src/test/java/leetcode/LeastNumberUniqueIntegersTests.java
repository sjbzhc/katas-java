package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class LeastNumberUniqueIntegersTests {

    @Test
    public void least_number_unique() {
        LeastNumberUniqueIntegers ln = new LeastNumberUniqueIntegers();
        int[] arr = {5,5,4};
        Assertions.assertThat(ln.findLeastNumOfUniqueInts(arr, 1)).isEqualTo(1);
    }

    @Test
    public void least_number_unique_2() {
        LeastNumberUniqueIntegers ln = new LeastNumberUniqueIntegers();
        int[] arr = {4,3,1,1,3,3,2};
        Assertions.assertThat(ln.findLeastNumOfUniqueInts(arr, 3)).isEqualTo(2);
    }

    @Test
    public void least_number_unique_3() {
        LeastNumberUniqueIntegers ln = new LeastNumberUniqueIntegers();
        int[] arr = {2,4,1,8,3,5,1,3};
        Assertions.assertThat(ln.findLeastNumOfUniqueInts(arr, 3)).isEqualTo(3);
    }

    @Test
    public void least_number_unique_4() {
        LeastNumberUniqueIntegers ln = new LeastNumberUniqueIntegers();
        int[] arr = {1};
        Assertions.assertThat(ln.findLeastNumOfUniqueInts(arr, 1)).isEqualTo(0);
    }
}
