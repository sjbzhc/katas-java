package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* Time: O(4^n  * 4)
* Space: O(n)
* */

public class LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private List<String> combinations = new ArrayList<>();
    private String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return combinations;

        this.digits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            combinations.add(path.toString());
            return;
        }

        String possibleLetters = letters.get(digits.charAt(index));

        for (char c : possibleLetters.toCharArray()) {
            path.append(c);
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() -1);
        }

    }
}
