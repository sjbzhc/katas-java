package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* dp represents
*     coins vs amount
*   0 1 2 3
* 1
* 2
* 3
* 4
* 5
*
* Each entry in dp counts the number of solutions for that coin-amount combination
* We build from the bottom up, so we use the result of the previous row to compute the current one as in:
*   int complement = j - coins[i-1]
*
* Time: O(mn)
* Space: O(mn)
* */

public class CoinChangeII {
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
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.amount = amount;
        return dfs(0, 0);
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
                if (coins[i-1] <= j) {
                    // current amount - coin of row below
                    int complement = j - coins[i-1];
                    dp[i][j] = dp[i-1][j] + dp[i][complement];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
