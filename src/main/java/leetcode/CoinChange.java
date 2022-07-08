package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {
    /*
    * Time: O(m * n), m = amount, n = number of coins
    * Space: O(m)
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
            numberCoins++;
        }
        return -1;
    }
}
