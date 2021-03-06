package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Time: O(n)
* Space: O(1)
* */

public class TwoSums {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int complement = target - nums[i];
            if (!map.containsKey(complement)) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }
}
