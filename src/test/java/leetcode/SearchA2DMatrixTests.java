package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SearchA2DMatrixTests {
    @Test
    public void test() {
        SearchA2DMatrix s = new SearchA2DMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        Assertions.assertThat(s.searchMatrix(matrix, 3)).isTrue();
    }
}
