package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumHealthTests {
    @Test
    public void test() {
        MinimumHealth mh = new MinimumHealth();

        int[] damage = {2,7,4,3};

        Assertions.assertThat(mh.minimumHealth(damage, 4)).isEqualTo(13);
    }
}
