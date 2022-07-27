package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class GetBiggestThreeRombusTests {
    @Test
    public void test() {
        GetBiggestThreeRombus gb = new GetBiggestThreeRombus();

        int[][] grid = {{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};

        int[] res = {228,216,211};

        Assertions.assertThat(gb.getBiggestThree(grid)).isEqualTo(res);
    }
}
