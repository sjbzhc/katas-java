package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class UniquePathsTests {
    @Test
    public void test() {
        UniquePaths up = new UniquePaths();

        Assertions.assertThat(up.uniquePaths(3, 7)).isEqualTo(28);
    }
}
