package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RotateImageTests {
    @Test
    public void rotate_image() {
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] expected = {{7,4,1},{8,5,2},{9,6,3}};

        ri.rotate(matrix);
        Assertions.assertThat(matrix).isEqualTo(expected);
    }
}
