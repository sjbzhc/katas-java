package leetcode;

public class WordSearch2 {
    public boolean exist(char[][] board, String s) {
        if (board == null || board.length == 0) {
            return false;
        }
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int r=0; r < ROWS; r++) {
            for (int c=0; c<COLS;c++) {
                boolean backtrackResult = backtrack(board, r, c, s, 0);
                if (backtrackResult) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String s, int depth) {
        int ROWS = board.length;
        int COLS = board[0].length;
        // diff 1
        if (depth >= s.length()) return true;

        // diff 2
        if(r == ROWS || r < 0 || c == COLS || c < 0) return false;
        if (board[r][c] != s.charAt(depth)) return false;


        board[r][c] = '#';
        boolean res = false;

        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0, 1};
        for (int d = 0; d<4; d++) {
            res = backtrack(board, r + rowOffsets[d], c + colOffsets[d], s, depth + 1);
            if (res) {
                break;
            }
        }

        board[r][c] = s.charAt(depth);
        return res;
    }
}
