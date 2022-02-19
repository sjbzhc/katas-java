package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TopKFrequentElementsTests {
    @Test
    public void top_k_frequent() {
        TopKFrequentElements tk = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        Assertions.assertThat(tk.topKFrequent(nums, 2)).isEqualTo(new int[]{2,1});
    }
}
