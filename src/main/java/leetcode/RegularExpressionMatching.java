package leetcode;

/*
*
* Time: O(mn)
* Space: O(mn)
*
* Base case 1: we reached the end of the strings -> true
* Base case 2: we reached only the end of pattern -> false
* We go through the chars in the strings one by one. If there is a match, we move forward in both text and pattern.
* If we encounter a '.', we can treat that as a match.
* When we encounter a star, we have two cases:
*   1: zero occurrences of the preceding character, so we move past * and preceding character with dfs(i, j+2)
*   2: one or more occurrences of the preceding character, we can consume one character from the
*      string and stay on the same pattern character, so we call dfs(i+1, j)
*
* */

public class RegularExpressionMatching {
    Boolean[][] memo;
    static String text;
    static String pattern;

    public boolean isMatch(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dfs(0, 0);
    }

    public boolean dfs(int i, int j) {
        // both pointers are one position after end of their respective strings. It means match is possible
        if (i >= text.length() && j >= pattern.length()) return true;

        // only pattern advanced, it means a char in text was not matched
        if (j >= pattern.length()) return false;

        if (memo[i][j] != null) return memo[i][j];


        // we need to check if i is within bounds to avoid checking undefined
        // the rest means a match, either due to character matching or wildcard in pattern
        boolean match = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');

        // is the following character a star?
        if ((j + 1) < pattern.length() && pattern.charAt(j + 1) == '*') {
            // when encountering a star we have 2 choices:
            // don't use star (j + 2) jumps over it OR
            // use the star: which means only the pointer of text advances
            memo[i][j] = dfs(i, j + 2) || (match && dfs(i + 1, j));
            return memo[i][j];
        }

        // there is no star, so we take a look at a simple match, which means moving forward with both
        if (match) {
            memo[i][j] = dfs(i + 1, j + 1);
            return memo[i][j];
        }
        return false;
    }
}
