package leetcode;

import java.util.Arrays;

/*
* Fill an array with 1
* Then, we go through the intervals
*   we pick an interval, and iterate through its range, adding to a sum if the value is 1
*       we set the values to 1
*   after finishing the iteration of the interval, we put the sum as the value for the interval in the result
*
* Time: O(n2)
* Space: O(n)
*
* */

public class AmountOfNewAreaPaintedEachDay {
    public int[] amountPainted(int[][] paint) {
        int maxLen = 0;
        for(int[] p : paint) {
            maxLen = Math.max(p[1], maxLen);
        }

        int[] area = new int[maxLen];

        Arrays.fill(area,1);

        int[] res = new int[paint.length];
        int index = 0;

        for(int[] p : paint) {
            int start = p[0];
            int end = p[1];
            int count = 0;
            for(int j=start; j<end; j++){
                if(area[j] == 1) {
                    count++;
                    area[j] = 0;
                }
            }
            res[index] = count;
            index++;
        }

        return res;
    }
}
