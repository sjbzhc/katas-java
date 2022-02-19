package leetcode;

public class WordSearch2 {
    int ROWS;
    int COLS;
    char[][] board;
    public boolean exist(char[][] board, String s) {
        if (board == null || board.length == 0) {
            return false;
        }
        ROWS = board.length;
        COLS = board[0].length;
        this.board = board;
        for (int r=0; r < ROWS; r++) {
            for (int c=0; c<COLS;c++) {
                boolean backtrackResult = backtrack(r, c, s, 0);
                if (backtrackResult) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, String word, int depth) {
        if (depth >= word.length()) {
            return true;
        }

        if (board[r][c] != word.charAt(depth)) return false;

        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,-1,0,1};

        char currentChar = board[r][c];
        board[r][c] = '#';

        for (int d=0;d<4;d++) {
            int newRow = r + rowOffset[d];
            int newCol = c + colOffset[d];
            if (newRow >= ROWS || newRow < 0 || newCol >= ROWS || newCol < 0) continue;

            if(backtrack(newRow, newCol, word, depth + 1)) return true;
        }

        board[r][c] = currentChar;

        return false;
    }
}
