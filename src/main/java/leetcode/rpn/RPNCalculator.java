package leetcode.rpn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RPNCalculator {

    List<RPNMethod> methods;
    Set<String> operands = new HashSet<>();
    public RPNCalculator(List<RPNMethod> methods) {
        this.methods = methods;
        for (RPNMethod method : methods) {
            operands.add(method.op);
        }
    }
    Stack<Double> stack = new Stack<>();

    public double calculate(String s) {
        String[] input = s.split(" ");

        for (String i : input) {
            if (operands.contains(i)) {
                process(i);
            } else {
                stack.push(Double.parseDouble(i));
            }
        }
        return stack.peek();
    }

    private void process(String operand) {
        for (RPNMethod method : methods) {
            if (method.isMethod(operand)) {
                method.calculate(stack);
            }
        }
    }
}
