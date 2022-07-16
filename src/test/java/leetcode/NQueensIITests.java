package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NQueensIITests {
    @Test
    public void n_queens() {
        NQueensII nq = new NQueensII();
        Assertions.assertThat(nq.totalNQueens(4)).isEqualTo(2);
    }
}
