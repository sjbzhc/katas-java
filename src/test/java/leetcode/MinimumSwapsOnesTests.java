package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumSwapsOnesTests {
    @Test
    public void min_swaps() {
        MinimumSwapsOnes ms = new MinimumSwapsOnes();

        int[] data = {1,0,1,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(1);
    }

    @Test
    public void min_swaps_3_swaps() {
        MinimumSwapsOnes ms = new MinimumSwapsOnes();

        int[] data = {1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(30);
    }

    @Test
    public void min_swaps_2() {
        MinimumSwapsOnes2 ms = new MinimumSwapsOnes2();

        int[] data = {1,0,1,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(1);
    }

    @Test
    public void min_swaps_2_2() {
        MinimumSwapsOnes ms = new MinimumSwapsOnes();

        int[] data = {1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(30);
    }
}
