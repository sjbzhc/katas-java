package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinChangeIITests {
    @Test
    public void test() {
        CoinChangeII cc = new CoinChangeII();

        int[] coins = {1,2,5};

        Assertions.assertThat(cc.change(5, coins)).isEqualTo(4);
    }

    @Test
    public void test_dp() {
        CoinChangeII cc = new CoinChangeII();

        int[] coins = {1,2,5};

        Assertions.assertThat(cc.changeDp(5, coins)).isEqualTo(4);
    }
}
