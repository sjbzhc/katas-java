package leetcode.expressionTree;

public abstract class Node2 {
    public Integer value;
    public String operand;
    public ExpressionNode2 left;
    public ExpressionNode2 right;

    public abstract int evaluate();
}
