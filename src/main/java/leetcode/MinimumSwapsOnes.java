package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */
public class MinimumSwapsOnes {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int i : data) ones += i;

        int l = 0;

        int onesInWindow = 0;

        for (int i =0; i< ones; i++) {
            onesInWindow += data[i];
        }

        int maxOnes = onesInWindow;

        for (int r=ones; r< data.length; r++) {
            onesInWindow += data[r];
            onesInWindow -= data[l];
            l++;

            maxOnes = Math.max(maxOnes, onesInWindow);
        }

        return ones - maxOnes;
    }
}
