package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* Time: O(m * n)
* Space: O(mn)
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
