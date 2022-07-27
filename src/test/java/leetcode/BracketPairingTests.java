package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BracketPairingTests {
    @Test
    public void test() {
        BracketPairing bp = new BracketPairing();
        Assertions.assertThat(bp.match("(??)")).isEqualTo(5);
    }

    @Test
    public void test_2() {
        BracketPairing bp = new BracketPairing();
        Assertions.assertThat(bp.match("(<{}>??]")).isEqualTo(1);
    }
}
