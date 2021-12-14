package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NQueensTests {
    @Test
    public void n_queens() {
        NQueens nq = new NQueens();
        Assertions.assertThat(nq.totalNQueens(4)).isEqualTo(2);
    }

    @Test
    public void n_queens_2() {
        NQueens2 nq = new NQueens2();
        Assertions.assertThat(nq.totalNQueens(4)).isEqualTo(2);
    }
}
