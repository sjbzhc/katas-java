package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaxProfitTest {
    @Test
    public void max_profit() {
        MaxProfit mp = new MaxProfit();
        int[] prices = new int[]{7,1,5,3,6,4};
        Assertions.assertThat(mp.maxProfit(prices)).isEqualTo(5);
    }

    @Test
    public void max_profit2() {
        MaxProfit mp = new MaxProfit();
        int[] prices = new int[]{10,1,1,1,1,100};
        Assertions.assertThat(mp.maxProfit(prices)).isEqualTo(90);
    }
}
