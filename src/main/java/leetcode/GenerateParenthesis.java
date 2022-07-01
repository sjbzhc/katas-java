package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(2^n)
* Space: O(2^n)
* */

public class GenerateParenthesis {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        backtrack(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder currentParenthesis, int open, int close, int n) {
        if (currentParenthesis.length() == 2 * n) {
            result.add(currentParenthesis.toString());
            return;
        }

        if (open < n) {
            currentParenthesis.append('(');
            backtrack(currentParenthesis, open + 1, close, n);
            currentParenthesis.deleteCharAt(currentParenthesis.length() -1);
        }

        if (close < open) {
            currentParenthesis.append(')');
            backtrack(currentParenthesis, open, close + 1, n);
            currentParenthesis.deleteCharAt(currentParenthesis.length() -1);
        }
    }
}
