package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class EditDistanceTests {
    @Test
    public void test() {
        EditDistance ed = new EditDistance();

        Assertions.assertThat(ed.minDistance("horse", "ros")).isEqualTo(3);
    }
}
