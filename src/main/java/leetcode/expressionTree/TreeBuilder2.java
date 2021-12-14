package leetcode.expressionTree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TreeBuilder2 {
    Set<String> operands;

    public TreeBuilder2() {
        String operandString = "+-/*";
        operands = new HashSet<>();
        for (char c : operandString.toCharArray()) {
            operands.add(String.valueOf(c));
        }
    }
    public Node2 buildTree(String[] postfix) {

        Stack<ExpressionNode2> stack = new Stack<>();

        for (String c : postfix) {
            if (operands.contains(c)) {
                ExpressionNode2 right = stack.pop();
                ExpressionNode2 left = stack.pop();
                ExpressionNode2 newNode = new ExpressionNode2(c, left, right);
                stack.push(newNode);
            } else {
                stack.push(new ExpressionNode2(c));
            }
        }
        return stack.pop();
    }
}
