package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PermutationIITests {
    @Test
    public void test() {
        PermutationII p2 = new PermutationII();

        int[] nums = {1,1,2};
        List<List<Integer>> res = List.of(List.of(1,1,2), List.of(1,2,1), List.of(2,1,1));
        Assertions.assertThat(p2.permuteUnique(nums)).isEqualTo(res);
    }
}
