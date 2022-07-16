package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time: O(n2)
* Space: O(n) (depends on sorting)
* */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<nums.length;i++) {
            int num = nums[i];

            // To avoid repeating in i
            if (i > 0 && num == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int threeSum = num + nums[l] + nums[r];
                if (threeSum > 0) r--;
                else if (threeSum < 0) l++;
                else {
                    res.add(List.of(num, nums[l], nums[r]));
                    l++;
                    // avoid repeating in l (could also do it in r)
                    while (nums[l] == nums[l - 1] && l < r) l++;
                }
            }
        }
        return res;
    }
}
