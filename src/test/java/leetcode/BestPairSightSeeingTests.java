package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BestPairSightSeeingTests {
    @Test
    public void test() {
        BestPairSightSeeing bp = new BestPairSightSeeing();

        int[] values = {8,1,5,2,6};

        Assertions.assertThat(bp.maxScoreSightseeingPair(values)).isEqualTo(11);
    }
}
