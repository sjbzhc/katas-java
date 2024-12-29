package leetcode.rpn;

import java.util.List;
import java.util.Stack;

public class RPNMethod {
    String op;

    public RPNMethod(String op) {
        this.op = op;
    }

    public boolean isMethod(String operand) {
        return op.equals(operand);
    }

    public void calculate(Stack<Double> stack) {
        throw new Error("Method not implemented.");
    }
}
