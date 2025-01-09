package leetcode;

/*
* (1+(4+5)-3)
*
* We use current num to hold the current number that will be added to the result
* We also use result to hold the value of all operations thus far. When parenthesis are present, the result value
* is pushed to the stack and result is used to store the value of the operations between the stack
* Then we pop from the stack to get the sign and then pop to add the previous value of result
*
* Time: O(n)
* Space: O(n)
* */

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        int currentRes = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Could be more than one digit
                currentNum = 10 * currentNum + (c - '0');
            } else if (c == '+') {
                currentRes += sign * currentNum;
                sign = 1;
                currentNum = 0;
            } else if (c == '-') {
                currentRes += sign * currentNum;
                sign = -1;
                currentNum = 0;
            } else if (c == '(') {
                // We push the result first, then sign
                stack.push(currentRes);
                currentRes = 0;
                stack.push(sign);
                sign = 1;
            // In total, we do: (operand on stack) + (sign on stack * (result from parenthesis))
            } else if (c == ')') {
                // currentRes will hold the value of the operation within the parenthesis
                currentRes += sign * currentNum;

                // Multiply with the sign. The sign might not have changed (but is +1 by default).
                currentRes *= stack.pop();

                // Add result previous to the parenthesis
                currentRes += stack.pop();
                currentNum = 0;
            }
        }
        return currentRes + (sign * currentNum);
    }
}
