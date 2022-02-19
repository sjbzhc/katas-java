package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
    * Time: O(n2)
    * Space: O(n)
    * */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (s == null || n == 0) return 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            Set<Character> set = new HashSet<>();
            int currentCount = 0;
            for (int j=i; j<n; j++) {
                char currentChar = s.charAt(j);
                if (!set.contains(currentChar)) {
                    set.add(currentChar);
                    currentCount++;
                } else {
                    set = new HashSet<>();
                    if (currentCount > max) max = currentCount;
                    currentCount = 0;
                }
            }
            if (currentCount > max) max = currentCount;
        }
        return max;
    }

    /*
    * Time: O(n)
    * Space: O(k) alphabet
    * */
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        int[] chars = new int[128];

        while(right < s.length()) {
            char c = s.charAt(right);
            chars[c]++;

            while(chars[c] > 1) {
                left++;
                chars[c]--;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }
}
