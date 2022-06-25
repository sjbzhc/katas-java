package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class SubsetsWithDupsTests {
    @Test
    public void subsets_with_dups() {
        SubsetsWithDups ss = new SubsetsWithDups();

        int[] nums = {1,2,2};
        List<List<Integer>> lists = ss.subsetsWithDup(nums);
        Assertions.assertThat(lists.size()).isEqualTo(6);
    }
}
