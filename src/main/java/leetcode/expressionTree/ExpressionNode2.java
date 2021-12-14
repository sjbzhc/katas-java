package leetcode.expressionTree;

import java.util.HashSet;
import java.util.Set;

public class ExpressionNode2 extends Node2 {


    public ExpressionNode2(String operand, ExpressionNode2 left, ExpressionNode2 right) {
        this.operand = operand;
        this.left = left;
        this.right = right;
    }

    public ExpressionNode2(String value) {
        this.value = Integer.valueOf(value);
    }

    @Override
    public int evaluate() {
        String operandString = "+-/*";
        Set<String> operands = new HashSet<>();
        for (char c : operandString.toCharArray()) {
            operands.add(String.valueOf(c));
        }

        if (operands.contains(operand)) {
            int l = left.evaluate();
            int r = right.evaluate();
            return evaluateOps(operand, l, r);
        }

        return value;
    }

    private int evaluateOps(String operand, int l, int r) {
        if (operand.equals("+")) return l + r;
        if (operand.equals("-")) return l - r;
        if (operand.equals("*")) return l * r;
        if (operand.equals("/")) return l / r;
        throw new UnsupportedOperationException("Operand not supported");
    }
}
