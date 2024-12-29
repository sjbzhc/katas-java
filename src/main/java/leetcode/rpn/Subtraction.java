package leetcode.rpn;

import java.util.Stack;

public class Subtraction extends RPNMethod {
    public Subtraction(String op) {
        super(op);
    }

    @Override
    public void calculate(Stack<Double> stack) {
        double b = stack.pop();
        double a = stack.pop();
        stack.push(a - b);
    }
}
