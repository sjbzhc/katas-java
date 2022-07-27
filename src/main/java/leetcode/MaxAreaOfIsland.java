package leetcode;

/*
* Time: O(R * C)
* Space: O(R * C)
* */

public class MaxAreaOfIsland {
    int ROWS;
    int COLS;
    int[][] grid;
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        this.grid = grid;
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r=0; r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (grid[r][c] == 1) {
                    ans = Math.max(ans, dfs(r, c));
                }
            }
        }
        return ans;
    }

    private int dfs(int row, int col) {
        grid[row][col] = 0;
        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0 ,1};

        int ans = 0;
        for (int d=0; d<4; d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];
            if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0 || grid[newRow][newCol] == 0) continue;
            ans += dfs(newRow, newCol);
        }
        return 1 + ans;
    }
}
