package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Time: O(s + t)
* Space: O(s + t)
* */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.equals("")) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) countT.put(c, countT.getOrDefault(c, 0) + 1);
        int have = 0;
        int need = countT.size();
        int[] res = new int[]{-1, 1};
        int l = 0;
        int resLen = Integer.MAX_VALUE;

        for (int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // The only relevant characters are the ones in t
            // If both counts are the same we satisfied one of the conditions
            if (countT.containsKey(c) && countT.get(c) == window.get(c)) {
                have++;
            }

            // we found a substring that has all chars in t, but maybe we could do better
            while (have == need) {
                // update result
                if (r - l + 1 < resLen) {
                    res = new int[]{l, r};
                    resLen = r - l + 1;
                }

                // this is where the optimization lies. We are shrinking the substring from l
                char lefChar = s.charAt(l);
                l++;
                window.put(lefChar, window.get(lefChar) - 1);

                // only check for chars in t
                // if what we have in the window is not longer enough to satisfy the chars in t reduce have
                if (countT.containsKey(lefChar) && window.get(lefChar) < countT.get(lefChar)) {
                    have--;
                }
            }
        }


        l = res[0];
        int r = res[1];

        if (resLen != Integer.MAX_VALUE) return s.substring(l, r + 1);
        return "";
    }
}
