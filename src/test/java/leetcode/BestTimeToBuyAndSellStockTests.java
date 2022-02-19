package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTests {
    @Test
    public void best_time() {
        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();
        int[] nums = {7,1,5,3,6,4};
        Assertions.assertThat(bt.maxProfit(nums)).isEqualTo(5);
    }
}
