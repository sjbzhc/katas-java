package leetcode.rpn;

import java.util.Stack;

public class Sqrt extends RPNMethod {

    public Sqrt(String op) {
        super(op);
    }

    @Override
    public void calculate(Stack<Double> stack) {
        stack.push(Math.sqrt(stack.pop()));
    }
}
