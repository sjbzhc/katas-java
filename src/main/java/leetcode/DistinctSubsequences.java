package leetcode;

import java.util.HashMap;

/*
* Time: O(mn)
* Space: O(mn)
* */

public class DistinctSubsequences {

    static String s;
    static String t;
    private HashMap<String, Integer> memo;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        memo = new HashMap<>();
        return helper( 0, 0);
    }

    private int helper(int i, int j) {

        int M = s.length();
        int N = t.length();

        // if we are at the end of both string we need to return a value
        // Base case j == N: we have exactly one way to match the rest of s to an empty string t (delete the rest of
        // the chars of s. This returns 1
        // i == M or  M - i < N - j: we don't have enough characters left in s to match t, so we return 0.
        if (j == N) return 1;
        if (M - i < N - j || i == M) return 0;

        String key = i + "#" + j;

        if (memo.containsKey(key)) return memo.get(key);

        // If the characters match, we have 2 choices:
        // include the subsequence (increase both indices)
        // Skip the current char at s
        if (s.charAt(i) == t.charAt(j)) {
            int ans = helper(i + 1, j + 1) + helper(i + 1, j);
            memo.put(key, ans);
            return ans;
        }
        int ans = helper(i + 1, j);
        memo.put(key, ans);
        return ans;
    }

    /*
     * Time: O(mn)
     * Space: O(mn)
     *
     * We move both indices forward until we don't encounter a match. In case of no match we move only pointer of s
     * forward.
     * We have a second case to consider when matching, which is having consecutive, repeated chars. To handle this,
     * we branch off, one case moving t forward and one case only moving s forward
     *
     *    r a b b i t
     * r            1 1  1 for rt means that for the string s=r, 1 subsequence is possible (empty string)
     * a            1 1
     * b            1 1
     * b            1 1
     * b            1 1
     * i            1 1
     * t            1 1
     *    0 0 0 0 0 0 1
     *
     * dp[i] = dp[i+1][j] + (dp[i+1][j+1] if they match) come from the recursive relation
     * we check if the next element is a match either way, and we increase both in case of a match
     * */
    public int numDistinctDp(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];

        // last column is 1. This means that an empty in t matches with the empty substring of any string s
        for (int r=0; r<=m; r++) {
            dp[r][n] = 1;
        }

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    // we move both forwards as it's a match and we pretend there is no match
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
