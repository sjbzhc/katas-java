package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**/

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int numberCoins = 0;
        boolean[] visited = new boolean[amount+1];
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0;i<n;i++) {
                int sum = q.poll();
                if(sum==amount) {
                    return numberCoins;
                }
                if(sum>amount || visited[sum]) {
                    continue;
                }
                visited[sum]=true;
                for(int coin:coins) {
                    q.add(sum+coin);
                }
            }
            numberCoins++;
        }
        return -1;
    }
}
