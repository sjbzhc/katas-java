package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MedianFinderTests {
    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(1.5);
        medianFinder.addNum(3);    // arr[1, 2, 3]
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(2);
    }
}
