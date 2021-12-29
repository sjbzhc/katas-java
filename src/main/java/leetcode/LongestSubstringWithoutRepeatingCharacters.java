package leetcode;

import java.util.HashSet;
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
    * Space: O(n)
    * */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (s == null || n == 0) return 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        Set<Character> set = new HashSet<>();

        while (index < n) {
            char currentChar = s.charAt(index);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                index++;
            } else {
                set = new HashSet<>(currentChar);
            }
            if (set.size() > max) max = set.size();
        }
        return max;
    }
}
