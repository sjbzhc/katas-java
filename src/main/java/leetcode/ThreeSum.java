package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time: O(n2)
* Space: O(n) (depends on sorting)
*
* Condition nums[i] <= 0 needed, as since we sorted, it is impossible to add to 0 with only positive integers
*
* In the else of twoSums:
* We found a match and no repeats are allowed, so we move low and high at the same time. This might lead to
* nums[low] == nums[low - 1], so we move low as long as necessary
* */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n && nums[i] <= 0;i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSums(nums, i, res);
            }
        }
        return res;
    }

    private void twoSums(int[] nums, int i, List<List<Integer>> res) {
        int low = i + 1;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum < 0) {
                low++;
            } else if (sum > 0) {
                high--;
            } else {
                res.add(List.of(nums[i], nums[low], nums[high]));
                low++;
                high--;
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            }
        }
    }
}
