package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CoinChangeTests {
    @Test
    public void coin_change() {
        CoinChange cc = new CoinChange();
        int[] coins = {1,2,5};
        Assertions.assertThat(cc.coinChange(coins, 11)).isEqualTo(3);
    }

    @Test
    public void coin_change_2() {
        CoinChange cc = new CoinChange();
        int[] coins = {186,419,83,408};
        Assertions.assertThat(cc.coinChange(coins, 6249)).isEqualTo(20);
    }
}