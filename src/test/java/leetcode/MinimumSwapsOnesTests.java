package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumSwapsOnesTests {
    @Test
    public void test() {
        MinimumSwapsOnes ms = new MinimumSwapsOnes();

        int[] data = {1,0,1,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(1);
    }
}
