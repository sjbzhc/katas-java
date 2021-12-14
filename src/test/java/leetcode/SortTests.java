package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.Arrays;

public class SortTests {
    @Test
    public void sort_tests() {
        int[] box1 = {1000,5};
        int[] box2 = {10000,3};
        int[] box3 = {1,10};
        int[][] boxes = {box1, box2, box3};

        int[][] descending = {box3, box1, box2};
        int[][] ascending = {box2, box1, box3};

        // Descending
        Arrays.sort(boxes, (a, b) -> b[1] - a[1]);
        Assertions.assertThat(boxes).isEqualTo(descending);

        Arrays.sort(boxes, (a, b) -> a[1] - b[1]);
        Assertions.assertThat(boxes).isEqualTo(ascending);
    }
}
