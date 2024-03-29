package leetcode;

public class MinimumPathSum {
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
