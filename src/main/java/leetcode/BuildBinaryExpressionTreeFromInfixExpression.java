package leetcode;

import java.util.Objects;
import java.util.Stack;

class ExpressionNode {
    char val;
    ExpressionNode left;
    ExpressionNode right;
    ExpressionNode() {this.val = ' ';}
    ExpressionNode(char val) { this.val = val; }
    ExpressionNode(char val, ExpressionNode left, ExpressionNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionNode that = (ExpressionNode) o;
        return val == that.val && Objects.equals(left, that.left) && Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}

/*
* Time: O(n)
* Space: O(n)
* */
public class BuildBinaryExpressionTreeFromInfixExpression {
    public ExpressionNode expTree(String s) {
    Stack<ExpressionNode> nodes = new Stack<>();
    Stack<Character> ops = new Stack<>();

    for (char c : s.toCharArray())
        if (Character.isDigit(c)) {
            nodes.push(new ExpressionNode(c));
        } else if (c == '(') {
            ops.push(c);
        } else if (c == ')') {
            while (ops.peek() != '(') {
                nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));
            }
            ops.pop();
        } else {
            // create tree from operands, prioritizing */ vs +-
            while (!ops.isEmpty() && compare(ops.peek(), c)) {
                nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));
            }
            ops.push(c);
        }

    while (!ops.isEmpty())
        nodes.push(buildNode(ops.pop(), nodes.pop(), nodes.pop()));

    return nodes.peek();
}

    private ExpressionNode buildNode(char op, ExpressionNode right, ExpressionNode left) {
        return new ExpressionNode(op, left, right);
    }

    // return true if op1 is a operator and priority(op1) >= priority(op2)
    boolean compare(char op1, char op2) {
        if (op1 == '(' || op1 == ')') return false;
        return op1 == '*' || op1 == '/' || op2 == '+' || op2 == '-';
    }
}
