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

import java.util.HashMap;
import java.util.Map;


/*
* Time: O(mn)
* Space: O(mn)
*
* insertion at w1: helper(i, j-1), meaning stay at w1, since we are adding a character, but move on with w2, as
* with the insertion on w1, they are understood to match at that combination of indices. So now need to solve the
* sub problem.
*
* deletion at w1: helper(i-1, j), meaning we moved the index of w1, since, after deleting, they are understood to match.
* We are now concerned with solving the sub problem.
*
* swap at w2: helper(i-1, j-1) meaning we moved at both, since a swap means chars in both strings were touched. So now
* focus on the sub problem
* */
public class EditDistance {

    public static String word1;
    public static String word2;
    Map<String, Integer> memo = new HashMap<>();
    public int minDistanceRecursive(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        return helper(word1.length() - 1,word2.length() - 1);
    }


    private int helper(int i, int j) {
        // Ran out of chars in word1, so we need the rest of the chars left in j to complete word2
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        String k = i + "#" + j;
        if (memo.containsKey(k)) return memo.get(k);

        if(word1.charAt(i) == word2.charAt(j)) {
            int option1 = helper(i - 1, j - 1);
            memo.put(k, option1);
            return memo.get(k);
        }

        int option2 = 1 +
                Math.min(
                helper(i,j-1),
                Math.min(
                        helper(i-1,j),
                        helper(i-1,j-1)
                )
        );

        memo.put(k, option2);

        return memo.get(k);
    }

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
