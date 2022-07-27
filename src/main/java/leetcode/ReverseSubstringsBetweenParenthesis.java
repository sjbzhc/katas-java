package leetcode;

import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */
public class ReverseSubstringsBetweenParenthesis {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) != ')') {
                stack.push(s.charAt(i) + "");
            } else {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }
                stack.pop();
                stack.push(sb.reverse().toString());
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
