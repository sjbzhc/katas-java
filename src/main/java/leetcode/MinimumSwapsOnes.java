package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */
public class MinimumSwapsOnes {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int i: data) ones += i;

        int onesInWindow = 0;
        for (int i=0; i<ones; i++) onesInWindow += data[i];
        int maxOnesInWindow = onesInWindow;

        int l=0;
        for (int r=ones; r<data.length; r++) {
            onesInWindow += data[r];
            onesInWindow -= data[l];
            l++;
            maxOnesInWindow = Math.max(maxOnesInWindow, onesInWindow);
        }

        return ones - maxOnesInWindow;
    }
}
