package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SearchInRotatedSortedArrayTests {
    @Test
    public void search_in_rotated() {
        SearchInRotatedSortedArray si = new SearchInRotatedSortedArray();
        int[] arr = new int[]{4,5,6,7,0,1,2};
        Assertions.assertThat(si.search(arr, 0)).isEqualTo(4);
    }
}
