package leetcode;

import java.util.Arrays;

public class MinimumSwapsOnes2 {
    public int minSwaps(int[] data) {
        int n = data.length;
        int ones = Arrays.stream(data).sum();
        int leftIndex = 0;
        int leftCount = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i =0; i < ones; i++) {
            count += data[i];
        }

        for (int rightIndex = ones; rightIndex<n; rightIndex++) {
            count += data[rightIndex];
            count -= data[leftIndex];
            leftIndex++;
            min = Math.min(min, ones - count);
        }
        return min;
    }
}
