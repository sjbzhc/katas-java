package leetcode;

import java.util.Arrays;

/*
* Time: O(n log n)
* Space: O(1)
*
* We are trying to guess an m that will hopefully lead to exactly k pairs
* m does not necessarily need to be a number in nums, it's only used to do the binary search
* We add the number of pairs because we are interested not in the distance between points
* but on the position on the sorted array that leads to k pairs of numbers
* */
public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        // low is when comparing a number against itself
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low <= high) {
            int m = (low + high) / 2;
            int numberOfPairs = 0;
            int left = 0;
            int right = 0;

            while (right < nums.length) {
                /*
                * m refers to low and high (binary search) not left and right (sliding window)
                * the distance is too large already, so no point in going further right
                * */
                if (nums[right] - nums[left] > m) left++;
                else {
                    /*
                    * Add the number of pairs. This is the sum of n up to n-1
                    * e.g. right - left = 4 -> 3 + 2 + 1 pairs = 6 pairs
                    * instead of calculating that sum, we add each element during the loop cycles
                    * */
                    numberOfPairs += (right - left);
                    right++;
                }
            }

            /*
            * We check if our guess works out. If it's too large, we need to constrain down
            * otherwise, we need more pairs
            * */
            if (numberOfPairs >= k) high = m - 1;
            else low = m + 1;
        }

        return low;
    }
}
