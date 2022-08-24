package leetcode;

import java.util.Arrays;

/*
* Time: O(n log n)
* Space: O(1)
* */
public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low <= high) {
            int m = (low + high) / 2;
            int count = 0;
            int left = 0;
            int right = 0;

            while (right < nums.length) {
                // we want to make the difference smaller equal than m and since array is sorted, we can increase left
                if (nums[right] - nums[left] > m) left++;
                else {
                    // add number of pairs
                    count += (right - left);
                    right++;
                }
            }

            if (count >= k) high = m - 1;
            else low = m + 1;
        }

        return low;
    }
}
