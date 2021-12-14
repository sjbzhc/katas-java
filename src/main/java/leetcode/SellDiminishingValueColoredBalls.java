package leetcode;

import java.util.*;

public class SellDiminishingValueColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        int mod = 1000000007;
        Arrays.sort(inventory);
        int currentIndex = inventory.length - 1;
        int currentValue = inventory[currentIndex];
        long profit = 0;
        while (orders > 0) {

            // Move index, so that we encompass all repeated numbers
            while (currentIndex >= 0 && inventory[currentIndex] == currentValue) {
                currentIndex--;
            }
            int nextValue = currentIndex < 0 ? 0 : inventory[currentIndex];
            // We count repeatedBalls from current index to length since we will take as many as we can to have as many
            // as the second highest number. So in the next iteration, the current count will be 2:
            // [2,4,6,8,10] <- repeatedBalls = 1, from currentIndex 4 to length
            // [2,4,6,8,8] <- repeatedBalls = 2, from currentIndex 3 to length
            int repeatedBalls = inventory.length - 1 - currentIndex;

            int possibleOrders = (currentValue - nextValue) * repeatedBalls;

            if (orders >= possibleOrders) {
                profit += (long)((currentValue + nextValue + 1) * (currentValue - nextValue) / 2) * repeatedBalls;
            } else {
                int numFullRow = orders / repeatedBalls;
                int remainder = orders % repeatedBalls;
                // What's this?
                profit += (long)((currentValue + (currentValue - numFullRow) + 1) * numFullRow / 2) * repeatedBalls;
                profit += (long)(currentValue - numFullRow) * remainder;
            }

            orders -= possibleOrders;
            profit = profit % mod;
            currentValue = nextValue;
        }

        return (int) profit;
    }
}
