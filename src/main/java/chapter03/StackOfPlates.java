package chapter03;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackOfPlates {
    int stackCapacity;
    ArrayList<Stack> stacks = new ArrayList<>();
    int currentStack = 0;

    public StackOfPlates(int stackCapacity) {
        this.stackCapacity = stackCapacity;
    }

    public void push(int v) {
        if (stacks.isEmpty()) {
            Stack stack = new Stack();
            stack.push(v);
            stacks.add(stack);
        } else if (stacks.get(currentStack).size() == 5) {
            currentStack++;
            Stack stack = new Stack();
            stack.push(v);
            stacks.add(stack);
        } else {
            stacks.get(currentStack).push(v);
        }
    }

    public int pop() {
        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        int v = (int) stacks.get(currentStack).pop();

        if (stacks.get(currentStack).isEmpty()) {
            stacks.remove(currentStack);
            currentStack--;
        }
        return v;
    }

    public int getNumberOfStacks() {
        return currentStack + 1;
    }
}
