package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class UniquePaths {
    /*
    *
    * Time: O(mxn)
    * Space: O(mxn)
    * */
    Map<String, Integer> memo = new HashMap<>();
    public int uniquePaths(int m, int n) {
        return helper(m-1, n-1);
    }

    private int helper(int r, int c) {
        if (r == 0 || c == 0) return 1;

        String k = r + "#" + c;
        if (memo.containsKey(k)) return memo.get(k);

        int v = helper(r - 1, c) + helper(r, c-1);
        memo.put(k, v);
        return v;
    }


    /*
     * Time: O(mn)
     * Space: O(mn)
     *
     * dp cells stand for number of paths from that cell. We calculate from bottom right, adding what's right and below
     * we initialize the outer row and col to 1
     *
     * 0 0 0 0 1
     * 0 0 0 0 1
     * 0 0 0 0 1
     * 1 1 1 1
     *
     * first iteration, first
     * Time: O(mn)
     * Space: O(mn)
     * */
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m-1], 1);

        for (int i=0; i<m-1; i++) {
            dp[i][n-1] = 1;
        }

        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
