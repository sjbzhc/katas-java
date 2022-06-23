package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=1;
        int ans = 0;

        while (r < prices.length) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                ans = Math.max(profit, ans);
            } else {
                l = r;
            }
            r++;
        }
        return ans;
    }
}
