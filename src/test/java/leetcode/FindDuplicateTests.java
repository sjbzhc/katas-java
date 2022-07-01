package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FindDuplicateTests {
    @Test
    public void test() {
        FindDuplicate fd = new FindDuplicate();

        int[] nums = {1,3,4,2,2};
        Assertions.assertThat(fd.findDuplicate(nums)).isEqualTo(2);
    }
}
