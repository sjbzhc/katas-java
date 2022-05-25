package leetcode;


import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */

public class ValidParentheses {
    public boolean isValid(String s) {
        /*
        go through string
        if its opening, add to stack
        if its closing, check if it matches with top of stack, if so, pop and continue
        if not return false
        */

        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(
                ')', '(',
                ']', '[',
                '}', '{');

        Set<Character> open = Set.of('(', '[', '{');

        for (char c : s.toCharArray()) {
            if (!open.contains(c)) {
                if (stack.isEmpty() || map.get(c) != stack.peek()) return false;
                else stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0;
    }
}
