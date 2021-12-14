package leetcode.expressionTree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressionNode extends Node {
    public Integer value;
    public String operand;

    public ExpressionNode(int value) {
        this.value = value;
    }

    public ExpressionNode(String operand) {
        this.operand = operand;
    }

    public int evaluate() {
        Set<String> operands = new HashSet<>();
        operands.addAll(List.of("+", "-", "*", "/"));
        if (operands.contains(operand)) {
            int l = left.evaluate();
            int r = right.evaluate();
            return evaluateOperand(l, r, operand);
        } else {
            return value;
        }
    }

    private int evaluateOperand(int l, int r, String operand) {
        if (operand.equals("+")) return l + r;
        if (operand.equals("-")) return l - r;
        if (operand.equals("*")) return l * r;
        if (operand.equals("/")) return l / r;
        throw new IllegalArgumentException("Operand not supported");
    }
}
