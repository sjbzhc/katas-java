package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PartitionEqualSubsetSumTests {
    @Test
    public void test() {
        PartitionEqualSubsetSum pe = new PartitionEqualSubsetSum();

        int[] nums = {1,5,11,5};

        Assertions.assertThat(pe.canPartition(nums)).isTrue();
    }
}
