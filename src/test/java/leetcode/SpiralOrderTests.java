package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class SpiralOrderTests {
    @Test
    public void test() {
        SpiralOrder so = new SpiralOrder();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        Assertions.assertThat(so.spiralOrder(matrix)).isEqualTo(List.of(1,2,3,6,9,8,7,4,5));
    }
}
