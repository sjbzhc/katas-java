package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* At each step, we can either add an element or not. Brute force 2^n
* We could cache with (index, sum), as the current index has 2 possible results of either including or not nums[i]
*
* For caching
* Time: O(n * sum(nums) / 2)
* Space: O(n * sum(nums) / 2)
*
* For DP:
* Time: O(n sum(nums) / 2)
* Space: O()
*
* Recurrence relation: the solution, if any, must be either when nums[i] == target or when 1 + sum(subarray) == target
* We store the sum of subarray as new entries in the set
* */

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int num : nums) {
            Set<Integer> tmp = new HashSet<>();
            for (int s : set) {
                tmp.add(s + num);
                tmp.add(s);
            }
            set = Set.copyOf(tmp);
            if (set.contains(target)) return true;
        }
        return false;
    }
}
