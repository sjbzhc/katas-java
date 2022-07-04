package leetcode;

/*
* Time: O(n2)
* Space: O(1)
* */

public class PalindromicSubstrings {
    int res = 0;
    String s;
    public int countSubstrings(String s) {
        this.s = s;
        for (int i=0; i<s.length(); i++) {
            helper(i, i);
            helper(i, i + 1);
        }
        return res;
    }

    private void helper(int l, int r) {
        while (l >= 0 && r< s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            res++;
        }
    }
}
