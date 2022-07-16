package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianTwoSortedArraysTests {
    @Test
    public void test() {
        MedianTwoSortedArrays mt = new MedianTwoSortedArrays();

        int[] arr1 = new int[]{1,3};
        int[] arr2 = new int[]{2};

        Assertions.assertThat(mt.findMedianSortedArrays(arr1, arr2)).isEqualTo(2.0);
    }

    @Test
    public void test2() {
        MedianTwoSortedArrays mt = new MedianTwoSortedArrays();

        int[] arr1 = new int[]{1,2,3,4,5,6,7,8};
        int[] arr2 = new int[]{1,2,3,4,5};

        Assertions.assertThat(mt.findMedianSortedArrays(arr1, arr2)).isEqualTo(4);
    }

    @Test
    public void test3() {
        MedianTwoSortedArrays mt = new MedianTwoSortedArrays();

        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        int[] arr2 = new int[]{1,2};

        Assertions.assertThat(mt.findMedianSortedArrays(arr1, arr2)).isEqualTo(6);
    }
}
