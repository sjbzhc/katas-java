package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SubsetsTests {
    @Test
    public void subsets() {
        Subsets ss = new Subsets();
        int[] nums = {1,2,3};
        Assertions.assertThat(ss.subsets(nums).size()).isEqualTo(8);

    }
}
