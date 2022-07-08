package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
*   0 1 2 3 4 5
* 5 1 x     z 1
* 2 1 y     y 1
* 1 1 z     x 1
*
* base case 0, with result 1, as any coin can lead to 0
* a cell in dp means: how many ways for coins to sum up to this amount
* x means: what is the solution for 1-5 =-4 (dp[row of 5=0][-4], since out of bounds -> 0
* y means: we can use the solution in y and the solution below (index - 1)
*   for y it's out of bounds, since it's 1-2=dp[row of 2=1][-1] -> 0
*   the solution below was 0
* z means: what is the solution for 1-1=0 (dp[row of 1=2][1] = 1
*
* Then we continue with next column
*
* Time: O(mn)
* Space: O(mn)
* */

/*
*   0 1 2 3 4 5
* 0 0 0 0 0 0 0
* 1 1 1 1 1 1 1
* 2 1 1 2 2 3 3
* 5 1 1 2 2 3 4
*
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


}
