package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(2^n)
* Space: O(s)
* */

public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        backtrack(0, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, List<String> current) {
        if (i == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int j=i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                current.add(s.substring(i, j + 1));
                backtrack(j + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
