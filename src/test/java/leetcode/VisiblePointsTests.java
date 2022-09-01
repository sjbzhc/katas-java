package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class VisiblePointsTests {
    @Test
    public void test() {
        VisiblePoints vp = new VisiblePoints();

        List<List<Integer>> points = List.of(List.of(2,1), List.of(2,2), List.of(3,3));

        Assertions.assertThat(vp.visiblePoints(points, 90, List.of(1,1))).isEqualTo(3);
    }
}
