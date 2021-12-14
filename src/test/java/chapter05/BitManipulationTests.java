package chapter05;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class BitManipulationTests {

    @Test
    public void bit_manipulation() {
        BitManipulation bm = new BitManipulation();
        Assertions.assertThat(bm.clearBitsThroughI(36, 3)).isEqualTo(4);
    }
}
