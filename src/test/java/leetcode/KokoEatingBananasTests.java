package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class KokoEatingBananasTests {
    @Test
    public void test() {
        KokoEatingBananas ke = new KokoEatingBananas();
        int[] piles = {3,6,7,11};
        Assertions.assertThat(ke.minEatingSpeed(piles, 8)).isEqualTo(4);
    }
}
