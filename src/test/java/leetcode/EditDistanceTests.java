package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class EditDistanceTests {
    @Test
    public void test() {
        EditDistance ed = new EditDistance();

        Assertions.assertThat(ed.minDistance("horse", "ros")).isEqualTo(3);
    }

    @Test
    public void test_rec() {
        EditDistance ed = new EditDistance();

        Assertions.assertThat(ed.minDistanceRecursive("horse", "ros")).isEqualTo(3);
    }
}
