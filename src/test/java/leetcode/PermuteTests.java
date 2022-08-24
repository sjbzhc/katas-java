package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PermuteTests {
    @Test
    public void permute() {
        Permutation permute = new Permutation();
        int[] nums = {1,2,3};

        List<List<Integer>> permute1 = permute.permute(nums);

        Assertions.assertThat(permute1.size()).isEqualTo(6);
    }
}
