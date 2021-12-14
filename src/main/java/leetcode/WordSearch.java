package leetcode;

/*
* Solution is linked to the depth of the recursion. If we manage to go as deep as the length of the word,
* it means we found a path with the necessary number of chars to build the string.
*
* For each of the chars in the board, we try to do backtracking.
*
* In backtracking we return false if the current char does not match what we expect: board[row][col] != word.charAt(index)
*
* If it matches, we continue, meaning we have been so far in a promising path. Then we try backtracking for all of the
* neighbors of the current cell.
*
* More calls to backtrack will be executed until we reach the desired depth d (which can only be achieved after traversing
* d adequate nodes.
*
* If all of the chars in the path return true, we clean after ourselves, putting back the char in the
* board: board[row][col] = word.charAt(index) (the recursive calls did this before reaching the calling place in the stack).
*
* */

public class WordSearch {
    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (backtrack(row, col, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        if (row < 0 || row == ROWS || col < 0 || col == COLS) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        boolean ret = false;

        board[row][col] = '#';

        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0, 1};

        /*
        * We keep on creating recursions until we reach the desired depth (index >= word.length(). At that moment,
        * we start to unwind, cleaning after ourselves (board[row][col] = word.charAt(index))
        * */
        for (int d = 0; d < 4; d++) {
            ret = backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            if (ret) {
                break;
            }
        }
        board[row][col] = word.charAt(index);
        return ret;
    }


}
