package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NextPermutationTests {
    @Test
    public void next_permutation() {
        NextPermutation np = new NextPermutation();
        int[] nums = {1,2,3};
        np.nextPermutation(nums);

        int[] expected = {1,3,2};

        Assertions.assertThat(nums).isEqualTo(expected);
    }

}
