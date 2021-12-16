package leetcode;

import leetcode.medianFromDataStream.MedianFinder;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MedianFromDataStreamTests {
    @Test
    public void median_from_data_streams() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);

        Assertions.assertThat(mf.findMedian()).isEqualTo(1.5);

        mf.addNum(3);

        Assertions.assertThat(mf.findMedian()).isEqualTo(2.0);

    }

    @Test
    public void median_from_data_streams_2() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(89);
        mf.addNum(1);

        Assertions.assertThat(mf.findMedian()).isEqualTo(45.0);

        mf.addNum(4);

        Assertions.assertThat(mf.findMedian()).isEqualTo(4.0);

    }
}
