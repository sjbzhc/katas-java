package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class DistinctSubsequencesTests {
    @Test
    public void test() {
        DistinctSubsequences ds = new DistinctSubsequences();

        Assertions.assertThat(ds.numDistinct("rabbbit", "rabbit")).isEqualTo(3);
    }

    @Test
    public void test_2() {
        DistinctSubsequences ds = new DistinctSubsequences();

        Assertions.assertThat(ds.numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe", "bddabdcae")).isEqualTo(10582116);
    }

    @Test
    public void test_dp() {
        DistinctSubsequences ds = new DistinctSubsequences();

        Assertions.assertThat(ds.numDistinctDp("rabbbit", "rabbit")).isEqualTo(3);
    }
}
