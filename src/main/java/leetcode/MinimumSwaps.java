package leetcode;

public class MinimumSwaps {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = nums[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }

            if (nums[i] <= min) {
                min = nums[i];
                minIndex = i;
            }
        }
        if (minIndex < maxIndex) return maxIndex + (n - minIndex - 2);
        return maxIndex + (n - minIndex - 1);
    }
}
