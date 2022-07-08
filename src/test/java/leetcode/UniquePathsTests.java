package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class UniquePathsTests {
    @Test
    public void test() {
        UniquePaths up = new UniquePaths();

        Assertions.assertThat(up.uniquePaths(3, 7)).isEqualTo(28);
    }

    @Test
    public void test_2() {
        UniquePaths up = new UniquePaths();

        Assertions.assertThat(up.uniquePaths2(3, 7)).isEqualTo(28);
    }
}
