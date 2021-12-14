package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MergeIntervalsTests {
    @Test
    public void merge_intervals() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[] iv1 = {1,3};
        int[] iv2 = {2,6};
        int[] iv3 = {8,10};
        int[] iv4 = {15,18};
        int[][] intervals = {iv4, iv3, iv2, iv1};

        int[] ex1 = {1,6};
        int[] ex2 = {8,10};
        int[] ex3 = {15,18};

        int[][] expected = {ex1, ex2, ex3};
        Assertions.assertThat(mergeIntervals.merge(intervals)).isEqualTo(expected);
    }

    @Test
    public void overlap() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[] iv1 = {1,3};
        int[] iv2 = {2,6};
        int[] iv3 = {8,10};

        Assertions.assertThat(mergeIntervals.overlap(iv1, iv2)).isTrue();
        Assertions.assertThat(mergeIntervals.overlap(iv2, iv3)).isFalse();
    }

    @Test
    public void merge_intervals2() {
        MergeIntervals2 mergeIntervals = new MergeIntervals2();
        int[] iv1 = {1,3};
        int[] iv2 = {2,6};
        int[] iv3 = {8,10};
        int[] iv4 = {15,18};
        int[][] intervals = {iv4, iv3, iv2, iv1};

        int[] ex1 = {1,6};
        int[] ex2 = {8,10};
        int[] ex3 = {15,18};

        int[][] expected = {ex1, ex2, ex3};
        Assertions.assertThat(mergeIntervals.merge(intervals)).isEqualTo(expected);
    }
}
