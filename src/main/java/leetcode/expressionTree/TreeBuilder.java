package leetcode.expressionTree;

/*
* Deque, Queue and Stack behave all differently.
* After adding 1,2,3:
*
* Deque:
* insert first/remove first -> 3 -> 2 -> 1
*
* Queue:
* poll -> 1 -> 2 -> 3 -> offer
*
* Stack:
* 1 -> 2 -> 3 -> push/pop
*
* For this purpose, Deque (adding and removing first) and Stack can be used.
*
* We iterate through the elements in the postfix.
*
* We keep on adding elements to the stack as long as we encounter numbers.
* When we encounter an operand, we pop two numbers (the first to pop will be the right side, as by using the stack we
* reversed their order).
* We then create a new Node, using the operand and the two popped nodes, and add it to the stack.
* We keep on doing this until the end of the postfix array.
*
* When we arrive at the end of the array, we return the single element in the stack, which is the expression tree.
* */

import java.util.*;

public class TreeBuilder {
    public Set<String> operands;

    public TreeBuilder() {
        String ops = "+-*/";
        operands = new HashSet<>();
        for (char c : ops.toCharArray()) {
            operands.add(String.valueOf(c));
        }
    }

    public Node buildTree(String[] postfix) {
        Stack<ExpressionNode> stack = new Stack<>();

        for (String s : postfix) {
            if (operands.contains(s)) {
                ExpressionNode right = stack.pop();
                ExpressionNode left = stack.pop();
                ExpressionNode newNode = new ExpressionNode(s);
                newNode.left = left;
                newNode.right = right;
                stack.add(newNode);
            } else {
                Integer value = Integer.valueOf(s);
                ExpressionNode newNode = new ExpressionNode(value);
                stack.push(newNode);
            }
        }
        return stack.pop();
    }
}
