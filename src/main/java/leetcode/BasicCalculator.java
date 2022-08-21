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
        int result = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Could be more than one digit
                currentNum = 10 * currentNum + (c - '0');
            } else if (c == '+') {
                result += sign * currentNum;
                sign = 1;
                currentNum = 0;
            } else if (c == '-') {
                result += sign * currentNum;
                sign = -1;
                currentNum = 0;
            } else if (c == '(') {
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * currentNum;
                // sign on top of stack, stack.pop() is the sign before the parenthesis
                result *= stack.pop();
                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();
                currentNum = 0;
            }
        }
        return result + (sign * currentNum);
    }
}
