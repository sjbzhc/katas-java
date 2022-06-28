package leetcode;


/*
* Time: O(m * n)
* Space: O(m * n)
* */
public class NumberOfIslands2 {
    int ROWS;
    int COLS;
    char[][] grid;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        this.grid = grid;
        ROWS = grid.length;
        COLS = grid[0].length;
        int count = 0;

        for (int r=0; r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(r, c);
                }
            }
        }
        return count;

    }

    private void dfs(int row, int col) {
        grid[row][col] = '#';

        int[] rowOffsets = {-1,0,1,0};
        int[] colOffsets = {0,-1,0,1};

        for (int d=0;d<4;d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];

            if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0 || grid[newRow][newCol] != '1') continue;

            dfs(newRow, newCol);
        }
    }

}
