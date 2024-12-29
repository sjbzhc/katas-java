package leetcode;

/*
* Time: O(n)
* Space: O(n)
*
* Brute force: 2 base cases, otherwise find the best option recursively of either going down or right
*
* dp: each element represents the sum of:
*   current cell (dp[i][j]) +
*   min of down or right Math.min(dp[i+1][j], dp[i][j+1])
*   bottom row and rightmost col are populated with their neighbors (bottom has no elements down, so only to the right)
*   base case is bottom
* */
public class MinimumPathSum {

    public int minPathSumBruteForce(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                // bottom except bottom right
                if (i == m-1 && j != n-1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                // right except bottom right
                } else if (j == n-1 && i != m-1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                // base case (has down and right)
                } else if (i != m-1 && j != n-1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                // is bottom right
                } else {
                    dp[i][j] = grid[i][j];
                }
            }

        }
        return dp[0][0];
    }
}
