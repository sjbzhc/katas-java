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
    class Pair {
        int index;
        int amount;

        public Pair(int index, int amount) {
            this.index = index;
            this.amount = amount;
        }
    }

    Map<Pair, Integer> map = new HashMap<>();
    int amount;
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;
        int res = dfs(0, 0);
        return res == 0 ? -1 : res;
    }

    private int dfs(int index, int currentAmount) {
        if (currentAmount == amount) return 1;

        if (currentAmount > amount) return 0;

        if (index == coins.length) return 0;

        Pair key = new Pair(index, currentAmount);

        if (map.containsKey(key)) return map.get(key);

        map.put(key, dfs(index, currentAmount + coins[index]) + dfs(index + 1, currentAmount));
        return map.get(key);
    }
}
