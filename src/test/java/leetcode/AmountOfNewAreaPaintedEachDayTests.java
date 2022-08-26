package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class AmountOfNewAreaPaintedEachDayTests {
    @Test
    public void test() {
        AmountOfNewAreaPaintedEachDay ap = new AmountOfNewAreaPaintedEachDay();

        int[][] paint = {{1,4}, {4,7}, {5,8}};

        int[] res = {3,3,1};

        Assertions.assertThat(ap.amountPainted(paint)).isEqualTo(res);
    }
}
