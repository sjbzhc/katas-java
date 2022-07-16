package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* The decision tree is to decide to either buy or sell, but with the constraint that if we bought
* we need to cool down and if we did not buy yet, we cannot sell
*
* 0 1 2 3 index
* 1 2 4 3 prices
*
* 0
*     b(-1)
*         bx
*         c(-1)
*             bx
*             c(-1)
*             s(3) <-
*         s(1)
*     c
*     sx
*
* Time: O(n)
* Space: O(n)
* */

public class BestTimeToBuyAndSellStockWithCooldown {

    class Pair {
        int index;
        boolean buying;

        public Pair(int index, boolean buying) {
            this.index = index;
            this.buying = buying;
        }
    }

    Map<Pair, Integer> dp = new HashMap<>();
    int[] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        return dfs(0, true);
    }

    private int dfs(int i, boolean buying) {
        if (i >= prices.length) return 0;

        Pair key = new Pair(i, buying);

        if (dp.containsKey(key)) return dp.get(key);

        int cooldown = dfs(i + 1, buying);

        if (buying) {
            int buy = dfs(i + 1, !buying) - prices[i];
            dp.put(key, Math.max(buy, cooldown));
        // we are selling in the current round. We can buy in 2 rounds or do nothing
        } else {
            // increment by to account for cool down day. We add because we sold
            int sell = dfs(i + 2, !buying) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }
}
