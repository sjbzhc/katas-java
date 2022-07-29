package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class MaximumLengthSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int posLen = 0;
        int negLen = 0;
        int ans = 0;

        for (int num : nums) {
            if (num == 0) {
                posLen = 0;
                negLen = 0;
            } else if (num > 0) {
                posLen++;
                if (negLen > 0) negLen++;
            } else {
                int tmp = posLen;

                posLen = negLen > 0 ? negLen + 1 : 0;
                negLen = tmp +1;
            }
            ans = Math.max(ans, posLen);
        }

        return ans;
    }
}
