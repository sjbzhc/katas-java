package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieDurationTests {
    @Test
    public void test() {
        MovieDuration md = new MovieDuration();

        int[] movieDurations = {90, 85, 75, 60, 120, 150, 125};

        int[] res = new int[]{0, 6};

        Assertions.assertThat(md.movieDuration(movieDurations, 250)).isEqualTo(res);
    }
}
