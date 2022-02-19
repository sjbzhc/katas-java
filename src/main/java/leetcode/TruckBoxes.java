package leetcode;

import java.util.Arrays;

/*
* Time: O(n log n) for sorting. We iterate one more time, in worst case through whole array.
* Space: O(1)
* */
public class TruckBoxes {
    public static int totalNumberOfBoxes(int[][] boxTypes, int truckSize) {
        int unitCount = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for(int[] boxType: boxTypes) {
            int boxesToAdd = Math.min(truckSize, boxType[0]);
            unitCount += boxesToAdd * boxType[1];
            truckSize -= boxesToAdd;
            if (truckSize == 0) break;
        }
        return unitCount;
    }
}
