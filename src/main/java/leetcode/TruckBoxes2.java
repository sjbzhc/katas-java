package leetcode;

import java.util.Arrays;

public class TruckBoxes2 {
    public static int totalNumberOfUnits(int[][] boxes, int capacity) {
        Arrays.sort(boxes, (a, b) -> b[1] - a[1]);
        int units = 0;
        for (int[] box : boxes) {
            int numberOfBoxes = Math.min(capacity, box[0]);
            units += numberOfBoxes * box[1];
            capacity -= numberOfBoxes;
            if (capacity == 0) {
                break;
            }
        }
        return units;
    }
}
