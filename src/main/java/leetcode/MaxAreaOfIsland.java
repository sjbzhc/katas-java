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
        if (row >= ROWS || row < 0 || col >= COLS || col < 0 || grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        return (1 + dfs(row+1, col) + dfs(row - 1, col) + dfs(row, col + 1) + dfs(row, col - 1));
    }
}
