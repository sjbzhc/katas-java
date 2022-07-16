package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class DetectSquaresTests {
    @Test
    public void test() {
        DetectSquares ds = new DetectSquares();

        int[] p1 = new int[]{3, 10};
        int[] p2 = new int[]{11, 2};
        int[] p3 = new int[]{3, 2};
        int[] p4 = new int[]{11, 10};

        ds.add(p1);
        ds.add(p2);
        ds.add(p3);
        Assertions.assertThat(ds.count(p4)).isEqualTo(1);
    }
}
