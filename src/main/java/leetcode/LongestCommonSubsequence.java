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

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    Map<String, Integer> memo = new HashMap<>();
    public static String text1;
    public static String text2;
    public int longestCommonSubsequenceRecursive(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        return helper(0, 0);
    }

    public int helper(int i, int j) {
        if (i >= text1.length() || j >= text2.length()) return 0;
        String k = i + "#" + j;

        if (memo.containsKey(k)) return memo.get(k);
        // i is not part of the solution
        int option1 = helper(i + 1, j);
        int firstOccurrence = text2.indexOf(text1.charAt(i), j);
        int option2 = 0;
        if (firstOccurrence != -1) {
            // i is part of the solution, we account for it with 1 +
            option2 = 1 + helper(i + 1, firstOccurrence + 1);
        }
        memo.put(k, Math.max(option1, option2));
        return memo.get(k);
    }
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

    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i<text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }


}
