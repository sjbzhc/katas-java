package leetcode;

import java.util.Arrays;

/*
* Time: O(K E)
* Space: O(V)
* Bellman-Ford
* */

public class CheapestFlightWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        int[] temp = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        Arrays.fill(temp, Integer.MAX_VALUE);
        prices[src] = 0;
        temp[src] = 0;

        while (k + 1 > 0) {
            for (int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                if (prices[source] == Integer.MAX_VALUE) continue;

                if (prices[source] + price < temp[destination]) {
                    temp[destination] = prices[source] + price;
                }
            }
            prices = Arrays.copyOf(temp, temp.length);
            k--;
        }
        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
    }
}
