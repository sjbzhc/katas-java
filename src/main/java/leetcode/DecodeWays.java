package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Time: O(n)
* Space: O(n)
* */

public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return helper(0, s);
    }

    private int helper(int index, String str) {
        if (memo.containsKey(index)) return memo.get(index);

        // base case, we survived thus far
        if (index == str.length()) return 1;

        // check to ensure single char is valid
        if (str.charAt(index) == '0') return 0;

        // we still have a single char, but it's not 0, so it's valid
        if (index == str.length() - 1) return 1;

        int ans = helper(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += helper(index + 2, str);
        }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }
}
