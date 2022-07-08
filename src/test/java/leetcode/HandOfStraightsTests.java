package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class HandOfStraightsTests {
    @Test
    public void test() {
        HandOfStraights ho = new HandOfStraights();

        int[] hand = {1,2,3,6,2,3,4,7,8};

        Assertions.assertThat(ho.isNStraightHand(hand, 3)).isTrue();
    }
}
