package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            int len = 0;
            if (!set.contains(num - 1)) {
                while (set.contains(num + len)) len++;
            }
            max = Math.max(max, len);
        }

        return max;
    }
}
