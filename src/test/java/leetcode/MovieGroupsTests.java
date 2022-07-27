package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieGroupsTests {
    @Test
    public void test() {
        MovieGroups mg = new MovieGroups();

        int[] movies = {1,5,4,6,8,9,2};

        Assertions.assertThat(mg.movieGroups(movies, 3)).isEqualTo(3);
    }
}
