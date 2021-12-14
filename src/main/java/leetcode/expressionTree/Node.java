package leetcode.expressionTree;

public abstract class Node {
    public Integer value;
    public String operand;
    public ExpressionNode left;
    public ExpressionNode right;

    public abstract int evaluate();
}
