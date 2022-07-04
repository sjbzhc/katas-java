package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**/

public class CoinChange {
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
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // if i=5 and the current coin is 3, then we want to know the number of coins for amount=2
                    int complement = dp[i - coin];
                    dp[i] = Math.min(dp[i], complement + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
