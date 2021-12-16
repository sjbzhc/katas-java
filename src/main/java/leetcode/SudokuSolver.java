package leetcode;

/*
* Each row/column is a vector, with the position in the vector mapping to the number in question.
*
* So if rows[1][2] == 1, it means that in the second row, we already have the number 3.
*
* boxIndex
*
 * */

public class SudokuSolver {
    int n = 3;
    int N = n * n;

    int [][] rows = new int[N][N + 1];
    int [][] columns = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int candidate, int row, int col) {
        int boxIndex = getBoxIndex(row, col);
        return rows[row][candidate] + columns[col][candidate] + boxes[boxIndex][candidate] == 0;
    }

    public void placeNumber(int number, int row, int col) {
        int boxIndex = getBoxIndex(row, col);

        rows[row][number]++;
        columns[col][number]++;
        boxes[boxIndex][number]++;
        board[row][col] = (char)(number + '0');
    }

    public void removeNumber(int number, int row, int col) {
        int boxIndex = getBoxIndex(row, col);

        rows[row][number]--;
        columns[col][number]--;
        boxes[boxIndex][number]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
        if (row == N - 1 && col == N - 1) {
            sudokuSolved = true;
        } else {
            if (col == N - 1) {
                // End of the row, go to next row, starting with col 0
                backtrack(row + 1, 0);
            } else {
                // Next col in row
                backtrack(row, col + 1);
            }
        }
    }

    private int getBoxIndex(int row, int col) {
        return (row / n) * n + (col / n);
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int candidate = 1; candidate < 10; candidate++) {
                if (couldPlace(candidate, row, col)) {
                    placeNumber(candidate, row, col);
                    placeNextNumbers(row, col);

                    if (!sudokuSolved) {
                        removeNumber(candidate, row, col);
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int r=0;r<N;r++) {
            for (int c=0;c<N;c++) {
                char num = board[r][c];
                if (num != '.') {
                    int candidate = Character.getNumericValue(num);
                    placeNumber(candidate, r, c);
                }
            }
        }

        backtrack(0, 0);
    }
}
