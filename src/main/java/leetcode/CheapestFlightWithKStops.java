package leetcode;

import java.util.Arrays;

/*
* Time: O(K*E)
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

        // k represents the stops
        while (k + 1 > 0) {
            // for each stop, we consider all flights. Valid flights are flights where the price[source] != MAX_VALUE
            // as that means that airport is reachable at this point.
            for (int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                if (prices[source] == Integer.MAX_VALUE) continue;

                int newPrice = prices[source] + price;

                if (newPrice < temp[destination]) {
                    temp[destination] = newPrice;
                }
            }
            prices = Arrays.copyOf(temp, temp.length);
            k--;
        }
        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
    }
}
