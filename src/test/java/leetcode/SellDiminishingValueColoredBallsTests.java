package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SellDiminishingValueColoredBallsTests {
    @Test
    public void sell_diminishing() {
        SellDiminishingValueColoredBalls sd = new SellDiminishingValueColoredBalls();

        int[] inventory = {2,5};
        Assertions.assertThat(sd.maxProfit(inventory, 4)).isEqualTo(14);
    }

    @Test
    public void sell_diminishing_2() {
        SellDiminishingValueColoredBalls sd = new SellDiminishingValueColoredBalls();

        int[] inventory = {2,8,4,10,6};
        Assertions.assertThat(sd.maxProfit(inventory, 20)).isEqualTo(110);
    }
}
