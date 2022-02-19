package leetcode;

import java.util.Arrays;

/*
* Time: O(n)
* Space: O(1)
* */

public class MinimumSwapsOnes {
    public int minSwaps(int[] data) {
        int numOnes = Arrays.stream(data).sum();
        int onesInWindow = 0;
        int maxOnes = 0;
        int left = 0;

        // Initialize window
        for (int i=0; i< numOnes; i++) {
            onesInWindow += data[i];
        }

        maxOnes = onesInWindow;

        for (int right=numOnes; right<data.length; right++) {
            onesInWindow += data[right];
            onesInWindow -= data[left];
            left++;

            maxOnes = Math.max(maxOnes, onesInWindow);
        }
        return numOnes - maxOnes;
    }
}
