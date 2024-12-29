package leetcode.rpn;

import java.util.List;
import java.util.Stack;

public class Addition extends RPNMethod {
    public Addition(String op) {
        super(op);
    }

    @Override
    public void calculate(Stack<Double> stack) {
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a + b);
    }
}
