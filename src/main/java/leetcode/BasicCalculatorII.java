package leetcode;

import java.util.Set;
import java.util.Stack;

/*
* Op is initialized to +, so any number will be added to the stack first. From them on
* the operation will be lagging on step behind. The op being one step behind makes this control necessary:
*       i == len - 1
*
* So for 3 + 5/2:
*   currentNumber is 3
*   op is +:
*       3 is added to stack
*       op is set to +
*   current number is 5
*       5 is added to the stack, since + is still the op
*       op is updated to /, to use when the next number is available
*
* Time: O(n)
* Space: O(n)
*
* */

public class BasicCalculatorII {
    public int calculate(String s) {
        Set<Character> ops = Set.of('+', '-', '*', '/');

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char prevOp = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            // i == len - 1 to also take the last digit
            if (ops.contains(currentChar) || i == len - 1) {
                if (prevOp == '-') stack.push(-currentNumber);
                else if (prevOp == '+') stack.push(currentNumber);
                else if (prevOp == '*') stack.push(stack.pop() * currentNumber);
                else if (prevOp == '/') stack.push(stack.pop() / currentNumber);

                prevOp = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
