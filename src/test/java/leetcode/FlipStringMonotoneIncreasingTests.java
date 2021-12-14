package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FlipStringMonotoneIncreasingTests {
    @Test
    public void min_flips() {
        FlipStringMonotoneIncreasing mf = new FlipStringMonotoneIncreasing();

        Assertions.assertThat(mf.minFlipsMonoIncr("010110")).isEqualTo(2);
    }

    @Test
    public void min_flips_2() {
        FlipStringMonotoneIncreasing mf = new FlipStringMonotoneIncreasing();

        Assertions.assertThat(mf.minFlipsMonoIncr("00011000")).isEqualTo(2);
    }

    @Test
    public void min_flips2() {
        FlipStringMonotoneIncreasing2 mf = new FlipStringMonotoneIncreasing2();

        Assertions.assertThat(mf.minFlipsMonoIncr("010110")).isEqualTo(2);
    }
}
