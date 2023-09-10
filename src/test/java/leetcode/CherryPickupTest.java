package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CherryPickupTest {
    @Test
    void test() {
        CherryPickup cp = new CherryPickup();
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, { 1, 1, 1}};
        Assertions.assertThat(cp.cherryPickup(grid)).isEqualTo(5);
    }
}
