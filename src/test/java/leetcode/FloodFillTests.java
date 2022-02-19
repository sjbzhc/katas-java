package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FloodFillTests {
    @Test
    public void flood_fill() {
        FloodFill ff = new FloodFill();
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] expected = {{2,2,2},{2,2,0},{2,0,1}};

        Assertions.assertThat(ff.floodFill(image, 1, 1, 2)).isEqualTo(expected);
    }
}
