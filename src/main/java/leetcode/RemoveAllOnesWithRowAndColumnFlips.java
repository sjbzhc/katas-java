package leetcode;

public class RemoveAllOnesWithRowAndColumnFlips {

    int[][] grid;
    int ROWS;
    int COLS;
    public boolean removeOnes(int[][] grid) {
        this.grid = grid;
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int c=0; c<COLS; c++) {
            if (this.grid[0][c] == 1) flipCol(c);
        }

        for (int r=1; r<ROWS; r++) {
            if (!uniform(r)) return false;
        }
        return true;
    }

    public boolean uniform(int row) {
        int curr = grid[row][0];
        for (int c=1; c<COLS; c++) {
            if (curr != grid[row][c]) return false;
        }
        return true;
    }

    private void flipCol(int col) {
        for (int r=0; r<ROWS; r++) {
            if (grid[r][col] == 1) grid[r][col] = 0;
            else grid[r][col] = 1;
        }
    }
}
