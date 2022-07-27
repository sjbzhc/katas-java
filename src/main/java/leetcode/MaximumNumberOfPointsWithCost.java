package leetcode;

/*
*
* dp is the best decision so far. We go row by row.
*                       j
* dp[i-1]:      |d0|d1|d2|
* dp[i]  :      |  |  |  |
* If we are at row i, and we want to know the value of cell (i, 2), we have:
*
* dp[i][j]   = max(d0-2, d1-1, d2)
* dp[i][j-1] = max(d0-1, d1) -> The only difference is that with have an additional -1 for each element
*
* This means that from left to right, we can build on the previous result, as
* dp[i][j] = max(dp[i][j-1] - 1, d2), with d2 = dp[i-1][j]
* dp[i][j] = max(dp[i][j-1] - 1, dp[i-1][j])
*
* Since we go row by row and dp stores the results from the previous row, this translates to:
* left[j] = max(left[j-1] - 1, dp[j])
*
*
* Time: O(mn)
* Space: O(n)
*
* */

public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int ROWS = points.length;
        int COLS = points[0].length;
        long[] dp = new long[COLS];
        for (int i=0; i<COLS; i++) {
            dp[i] = points[0][i];
        }
        long[] left = new long[COLS];
        long[] right = new long[COLS];

        for (int i =1; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (j == 0) left[j] = dp[j];
                else left[j] = Math.max(left[j-1] - 1, dp[j]);
            }

            for (int j = COLS-1; j>=0; j--) {
                if (j == COLS - 1) right[j] = dp[j];
                else right[j] = Math.max(right[j+1] - 1, dp[j]);
            }

            for (int j=0; j<COLS; j++) {
                dp[j] = points[i][j] + Math.max(left[j], right[j]);
            }
        }

        long res = Integer.MIN_VALUE;

        for (long i : dp) {
            res = Math.max(res, i);
        }

        return res;
    }
}
