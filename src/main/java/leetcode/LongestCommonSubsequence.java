package leetcode;

/*
*
* dp represents:
*
*   a c e
* a        0
* b        0
* c        0
* d        0
* e        0
*   0 0 0
*
* If the chars don't match, we take a look in the 2 sub-matrices of r+1 and c+1
* If they match, we move diagonally to r+1, c+1 to continue looking
*
* To solve we backtrack the path from the bottom right corner
* if they match, we moved diagonally, so we move back diagonally, adding 1
* otherwise, we came from either bellow or right, so we set the current to the max of both
*
* Time: O(mn)
* Space: O(mn)
* */

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i>=0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i+ 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
