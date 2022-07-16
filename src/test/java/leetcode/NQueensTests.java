package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class NQueensTests {
    @Test
    public void test() {
        NQueens nq = new NQueens();

        List<List<String>> res = List.of(
                List.of(".Q..","...Q","Q...","..Q."),
                List.of("..Q.","Q...","...Q",".Q..")
        );

        Assertions.assertThat(nq.solveNQueens(4)).isEqualTo(res);
    }
}
