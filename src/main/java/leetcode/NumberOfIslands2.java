package leetcode;

public class NumberOfIslands2 {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        for (int r=0; r < ROWS; r++) {
            for (int c=0; c< COLS; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r == ROWS || r < 0 || c == COLS || c  < 0) return;

        if (grid[r][c] != '1') return;

        grid[r][c] = '0';

        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0, 1};
        for (int d=0;d<4;d++) {
            dfs(grid, r + rowOffsets[d], c + colOffsets[d]);
        }
    }
}
