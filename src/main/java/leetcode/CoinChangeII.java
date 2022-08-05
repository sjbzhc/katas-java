package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
*
* Time: O(mn)
* Space: O(mn)
* */

/*
*   0 1 2 3 4 5   dp means: how many coins of denomination i do I need to add up to amount j
* 0 1 0 0 0 0 0
* 1 1 1 1 1 1 1
* 2 1 1 2 2 3 3
* 5 1
*
*
* to calculate one cell, we take a look at the number of current combinations for amount j
* (which is the cell above at i-1) and add it to the number of combinations for amount - coin
* */

public class CoinChangeII {

    /*
     * Time: O(mn)
     * Space: O(mn)
     * */

    Map<String, Integer> map = new HashMap<>();
    int target;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.target = amount;
        return dfs(0, 0);
    }

    private int dfs(int i, int amount) {
        if (amount == target) return 1;

        if (amount > target) return 0;

        if (i == coins.length) return 0;

        String key = i + "#" + amount;

        if (map.containsKey(key)) return map.get(key);

        map.put(key, dfs(i, amount + coins[i]) + dfs(i + 1, amount));
        return map.get(key);
    }

    public int changeDp(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // fill out first column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // would the horizontal solution be within bounds?
                if (j - coins[i-1] >= 0) {
                    // current amount - coin of row below
                    int complement = j - coins[i-1];
                    dp[i][j] = dp[i-1][j] + dp[i][complement];
                }
                // horizontal solution out of bounds
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
