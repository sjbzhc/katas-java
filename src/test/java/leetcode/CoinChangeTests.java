package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CoinChangeTests {
    @Test
    public void coin_change() {
        CoinChange cc = new CoinChange();
        int[] coins = {1,5,2};
        Assertions.assertThat(cc.coinChangeBFS(coins, 11)).isEqualTo(3);
        Assertions.assertThat(cc.coinChangeDP(coins, 11)).isEqualTo(3);
    }

    @Test
    public void coin_change_2() {
        CoinChange cc = new CoinChange();
        int[] coins = {186,419,83,408};
        Assertions.assertThat(cc.coinChangeBFS(coins, 6249)).isEqualTo(20);
        Assertions.assertThat(cc.coinChangeDP(coins, 6249)).isEqualTo(20);
    }

    @Test
    public void coin_change_3() {
        CoinChange cc = new CoinChange();
        int[] coins = {2, 5, 11, 23};
        Assertions.assertThat(cc.coinChangeDP(coins, 23)).isEqualTo(1);
    }
}