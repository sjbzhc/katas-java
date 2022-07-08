package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MergeTripletsTests {
    @Test
    public void test() {
        MergeTriplets mt = new MergeTriplets();
        int[][] triplets = {{3,4,5},{4,5,6}};
        int[] target = {3,2,5};

        Assertions.assertThat(mt.mergeTriplets(triplets, target)).isFalse();
    }

    @Test
    public void test_true() {
        MergeTriplets mt = new MergeTriplets();
        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};

        Assertions.assertThat(mt.mergeTriplets(triplets, target)).isTrue();
    }
}
