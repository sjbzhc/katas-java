package leetcode;

import java.util.Arrays;

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
