package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FindKthSmallestPairDistanceTests {
    @Test
    public void test() {
        FindKthSmallestPairDistance fk = new FindKthSmallestPairDistance();

        int[] nums = {1,3,1};

        Assertions.assertThat(fk.smallestDistancePair(nums, 1)).isEqualTo(0);
    }
}
