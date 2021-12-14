package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TruckBoxesTests {

    @Test
    public void truck_box_tests() {
        int[] b1 = {1,3};
        int[] b2 = {2,2};
        int[] b3 = {3,1};
        int[][] boxes = {b1, b2, b3};
        Assertions.assertThat(TruckBoxes.totalNumberOfBoxes(boxes, 4)).isEqualTo(8);
    }

    @Test
    public void truck_box_tests_2() {
        int[] b1 = {1,3};
        int[] b2 = {2,2};
        int[] b3 = {3,1};
        int[][] boxes = {b1, b2, b3};
        Assertions.assertThat(TruckBoxes2.totalNumberOfUnits(boxes, 4)).isEqualTo(8);
    }
}
