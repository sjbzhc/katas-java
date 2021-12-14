package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class KthFactorTests {
    @Test
    public void kth_factor() {
        KthFactor kf = new KthFactor();
        Assertions.assertThat(kf.kthFactor(12, 3)).isEqualTo(3);
    }

    @Test
    public void kth_factor_2() {
        KthFactor kf = new KthFactor();
        Assertions.assertThat(kf.kthFactor(4, 4)).isEqualTo(-1);
    }

    @Test
    public void kth_factor_3() {
        KthFactor kf = new KthFactor();
        Assertions.assertThat(kf.kthFactor(1, 1)).isEqualTo(1);
    }

    @Test
    public void kth_factor_4() {
        KthFactor kf = new KthFactor();
        Assertions.assertThat(kf.kthFactor(1000, 3)).isEqualTo(4);
    }
}
