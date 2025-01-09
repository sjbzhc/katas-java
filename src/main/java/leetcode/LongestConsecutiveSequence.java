package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* Time: O(n)
* Space: O(n)
* */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int len = 0;
            // The current number has no predecessor, so it starts its own sequence
            if (!set.contains(num - 1)) {
                while (set.contains(num + len)) len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}
