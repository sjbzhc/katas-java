package leetcode;

/*
*
* We count the zeros in the window of all ones
* We initialize ans with zerosInWindow
* We minimize zerosInWindow
* We maintain a sliding window, and we go around the array 2 times, as we want to check the full circular array.
*   right idx adds when zero is encountered
*   left idx removes when zero is encountered
*
* Time: O(n)
* Space: O(1)
* */

public class MinimumSwapsOnesII {
    public int minSwaps(int[] nums) {
        int ones = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) ones += nums[i];

        int zerosInWindow = 0;
        for (int i = 0; i < ones; ++i) {
            if (nums[i] == 0) zerosInWindow++;
        }

        int ans = zerosInWindow;
        // we check for cycle, so end can wrap 2 times around array
        int left = 0;
        for (int right = ones; right < 2*n; right++) {

            if (nums[left % n] == 0) zerosInWindow--;
            if (nums[right % n] == 0) zerosInWindow++;

            ans = Math.min(ans, zerosInWindow);
            left++;
        }
        return ans;
    }
}
