package leetcode;

/*
* Time: O(mn)
* Space: O(mn)
* */

public class LongestIncreasingPath {
    int ROWS;
    int COLS;
    int[][] matrix;
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        this.matrix = matrix;
        ROWS = matrix.length;
        COLS = matrix[0].length;
        cache = new int[ROWS][COLS];
        int ans = 0;

        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                ans = Math.max(ans, dfs(r, c));
            }
        }

        return ans;
    }

    private int dfs(int r, int c) {
        if (cache[r][c] != 0) return cache[r][c];

        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0, 1};

        for (int d=0; d<4; d++) {
            int newRow = r + rowOffsets[d];
            int newCol = c + colOffsets[d];

            if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0 || matrix[newRow][newCol] <= matrix[r][c]) continue;

            cache[r][c] = Math.max(cache[r][c], dfs(newRow, newCol));
        }
        // for cell r,c itself
        cache[r][c] += 1;
        return cache[r][c];
    }
}
