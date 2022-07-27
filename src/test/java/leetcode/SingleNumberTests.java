package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SingleNumberTests {
    @Test
    public void test() {
        SingleNumber sn = new SingleNumber();

        int[] nums = {4,1,2,1,2};

        Assertions.assertThat(sn.singleNumber(nums)).isEqualTo(4);
    }
}
