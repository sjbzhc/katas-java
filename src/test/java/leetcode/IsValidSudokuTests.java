package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class IsValidSudokuTests {
    @Test
    public void test() {
        IsValidSudoku iv = new IsValidSudoku();

        char[][] sudoku = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        Assertions.assertThat(iv.isValidSudoku(sudoku)).isTrue();
    }
}
