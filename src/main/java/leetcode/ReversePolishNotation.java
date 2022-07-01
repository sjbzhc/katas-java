package leetcode;

import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t == "+") stack.push(stack.pop() + stack.pop());
            else if (t == "*") stack.push(stack.pop() * stack.pop());
            else if (t == "-") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if (t == "/") {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}
