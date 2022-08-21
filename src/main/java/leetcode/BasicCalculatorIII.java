package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */

public class BasicCalculatorIII {
    public int calculate(String s) {
        if (s == null) return 0;
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        return calc(q);
    }

    private int calc(Queue<Character> q) {
        Set<Character> ops = Set.of('+', '-', '*', '/');
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char prevOp = '+';

        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                currentNumber = 10 * currentNumber + c - '0';
            } else if (c == '(') {
                currentNumber = calc(q);
            } else if (ops.contains(c)) {
                eval(stack, currentNumber, prevOp);
                currentNumber = 0;
                prevOp = c;
            } else if (c == ')') {
                break;
            }
        }
        eval(stack, currentNumber, prevOp);

        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }

    private void eval(Stack<Integer> stack, int num, char op) {
        if (op == '+') stack.push(num);
        if (op == '-') stack.push(-num);
        if (op == '*') stack.push(stack.pop() * num);
        if (op == '/') stack.push(stack.pop() / num);
    }
}
