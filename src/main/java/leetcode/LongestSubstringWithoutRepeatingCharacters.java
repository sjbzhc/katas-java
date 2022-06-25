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
    * Space: O(k) alphabet
    * */
    public int lengthOfLongestSubstring2(String s) {
        int l = 0;
        int[] count  = new int[128];
        int res = 0;

        for(int r=0; r<s.length();r++) {
            count[s.charAt(r)]++;

            while (count[s.charAt(r)] > 1) {
                count[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
