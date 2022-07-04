package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BestTimeToBuyAndSellStockWithCooldownTests {
    @Test
    public void test() {
        BestTimeToBuyAndSellStockWithCooldown bt = new BestTimeToBuyAndSellStockWithCooldown();

        int[] prices = {1,2,3,0,2};

        Assertions.assertThat(bt.maxProfit(prices)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        BestTimeToBuyAndSellStockWithCooldown bt = new BestTimeToBuyAndSellStockWithCooldown();

        int[] prices = {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};

        Assertions.assertThat(bt.maxProfit(prices)).isEqualTo(428);
    }
}
