package chapter03;

import java.util.Stack;

/*
* Time: O(1)
* Space: O(n)
* */

public class StackMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int v) {
        stack.push(v);
        if (min.isEmpty() || v < min.peek()) {
            min.push(v);
        }
    }

    public int pop() {
        int v = stack.pop();
        if (v == min.peek()) {
            min.pop();
        }
        return v;
    }

    public int min() {
        return min.peek();
    }
}