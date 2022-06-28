package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(m*n)
* Space: O(m*n)
* */

public class SurroundedRegions {

    class Pair {
        public Integer r;
        public Integer c;

        public Pair(Integer r, Integer c) {
            this.r = r;
            this.c = c;
        }
    }
    int ROWS;
    int COLS;
    char[][] board;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        List<Pair> borders = new ArrayList<>();

        for (int r=0; r<ROWS;r++) {
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, COLS - 1));
        }

        for (int c=0; c<COLS;c++) {
            borders.add(new Pair(0, c));
            borders.add(new Pair(ROWS - 1, c));
        }

        for (Pair p : borders) {
            dfs(p.r, p.c);
        }

        for (int r=0;r<ROWS;r++) {
            for (int c=0; c<COLS;c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'E') board[r][c] = 'O';
            }
        }
    }

    public void dfs(int r, int c) {
        if (board[r][c] != 'O') return;

        board[r][c] = 'E';

        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0, 1};

        for (int d=0;d<4;d++) {
            int newRow = r + rowOffsets[d];
            int newCol = c + colOffsets[d];

            if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0) continue;

            dfs(newRow, newCol);
        }
    }
}
