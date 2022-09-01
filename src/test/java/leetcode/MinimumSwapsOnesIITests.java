package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MinimumSwapsOnesIITests {
    @Test
    public void min_swaps() {
        MinimumSwapsOnesII ms = new MinimumSwapsOnesII();

        int[] data = {1,0,1,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(1);
    }

    @Test
    public void min_swaps_3_swaps() {
        MinimumSwapsOnesII ms = new MinimumSwapsOnesII();

        int[] data = {1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(30);
    }

    @Test
    public void min_swaps_2_2() {
        MinimumSwapsOnesII ms = new MinimumSwapsOnesII();

        int[] data = {1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1};

        Assertions.assertThat(ms.minSwaps(data)).isEqualTo(30);
    }
}
