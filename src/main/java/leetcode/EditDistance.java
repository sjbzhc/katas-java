package leetcode;

/*
* Time: O(mn)
* Space: O(mn)
*
* position in dp[i][j] stands for how many transformations are necessary to transform s2[j:] to s1[i:] or at the same
* time the number of transformation to transform s1[i:] to s2[j:]
*
*   r o s
* h 3 3 4 5 <- 5 indicates that to transform an empty s2 to s1=horse, 5 transformations are necessary
* o 3 2 3 4
* r 2 2 2 3
* s 3 2 1 2
* e 3 2 1 1
*   3 2 1 0
* */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        if (m * n == 0) return m + n;

        int lastRow = dp.length - 1;
        int lastCol = dp[0].length - 1;

        for (int r=lastRow; r >= 0; r--) {
            dp[r][lastCol] = lastRow - r;
        }

        for (int c=lastCol; c >= 0; c--) {
            dp[lastRow][c] = lastCol - c;
        }

        for (int r=lastRow - 1; r >= 0; r--) {
            for (int c=lastCol - 1; c >= 0; c--) {
                if (word1.charAt(r) == word2.charAt(c)) {
                    dp[r][c] = dp[r+1][c+1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r+1][c], Math.min(dp[r][c+1], dp[r+1][c+1]));
                }
            }
        }
        return dp[0][0];
    }
}
