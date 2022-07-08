package leetcode;

/*
* leftMin and leftMax represent the range of valid number of open parenthesis
* leftMax can never be negative, as that would mean we did not have the corresponding
* closing parenthesis before, so we won't be able to close it ever
*
* thanks to this guard, we don't really care for leftMin's value, as if it's below 0, it
* was just due to *.
*
* Time: O(n)
* Space: O(1)
* */

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }
        return leftMin == 0;
    }
}
