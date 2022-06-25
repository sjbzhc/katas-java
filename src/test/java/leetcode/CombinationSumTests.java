package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;


public class CombinationSumTests {

    @Test
    public void combination_sum() {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2,3,6,7};
        Assertions.assertThat(cs.combinationSum(candidates, 7).size()).isEqualTo(2);
    }


}
