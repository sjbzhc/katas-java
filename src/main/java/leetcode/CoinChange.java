package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

    /*
    * Time: O(mxn)
    * Space: O(mxn)
    * */
    int[] coins;
    Integer[][] cache;
    public int coinChangeRecursive(int[] coins, int amount) {
        this.coins = coins;
         cache = new Integer[coins.length + 1][amount + 1];
        int ret = helper(0, amount);
        return ret == Integer.MAX_VALUE - 1 ? - 1 : ret;
    }

    public int helper(int coinIndex, int amount) {
        if (amount < 0 || coinIndex >= coins.length) return Integer.MAX_VALUE - 1;
        if (amount == 0) return 0;

        if (cache[coinIndex][amount] != null) return cache[coinIndex][amount];

        cache[coinIndex][amount] = Math.min(
                // use the current coin
                1 + helper(coinIndex, amount - coins[coinIndex]),
                // skip the current coin
                helper(coinIndex + 1, amount)
        );
        return cache[coinIndex][amount];
    }

    /*
     * Brute force with 2^n leafs
     *
     * Time: O(n*amount)
     * Space: O(n)
     *
     * For each amount, we can check against all possible coins. There are 2 options:
     *   1) The coin matches the amount, so a - coins[coinIndex] == 0, leading to dp[0] == 0, since we initialized it
     *   2) The amount can be created by a combination of the current coin and it's complement: 1+ dp[complement], with
     *   complement returning either the number of coins to create it or the sentinel value. Since we do
     *   Math.min(dp[a], dp[complement] + 1), dp[a] would stay the same if the complement doesn't return a meaningful
     *   value, as it would return the sentinel value.
     *   The base case is when a - coins[coinIndex] = 0, which means the amount and coin match. This leads to the
     *   complement being 0 and with dp[0] initialized to 0, we get 1 for Math.min(dp[a], dp[complement] + 1)
     *
     * */
    public int coinChangeDP(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // i refers to the current amount being computed
        for (int a = 1; a <= amount; a++) {
            for (int coinIndex=0; coinIndex<coins.length; coinIndex++) {
                if (a - coins[coinIndex] >= 0) {
                    // if i=5 and the current coin is 3, then we want to know the number of coins for amount=2
                    int complement = a - coins[coinIndex];
                    dp[a] = Math.min(dp[a], dp[complement] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /*
    * The problem is an unweighted graph, where we are trying to find the shortest path.
    * Each node represents a sum of money. The first node is therefore 0 as we start with no coins.
    * Each edge represents adding a coin to the sum. On each level, we add each coin to the sum, creating
    * as many paths as there are coins.
    * */
    public int coinChangeBFS(int[] coins, int amount) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int numberCoins = 0;
        boolean[] visited = new boolean[amount + 1];
        while (!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                int sum = q.poll();
                if(sum == amount) {
                    return numberCoins;
                }

                if(sum > amount || visited[sum]) {
                    continue;
                }
                visited[sum] = true;
                for(int coin : coins) {
                    q.add(sum + coin);
                }
            }
            // After finishing creating all the different paths (one per coin) of the current level, increase the counter
            numberCoins++;
        }
        return -1;
    }
}
