package leetcode;

/*
* Time: O(n2)
* Space: O(1)
* */

public class LongestPalindromeSubstring {
    int low;
    int maxLength;
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i=0;i<s.length();i++) {
            check(s, i, i);
            check(s, i, i+1);
        }

        return s.substring(low, low + maxLength);
    }

    private void check(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }

        // after last while, we went one too far left and right
        // for right it doesn't matter, as substring is not inclusive [), but for left we need correction
        if (high - low - 1 > maxLength) {
            maxLength = high - low - 1;
            this.low = low + 1;
        }
    }
}
