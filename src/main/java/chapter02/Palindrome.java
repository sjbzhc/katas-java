package chapter02;

import java.util.Stack;

public class Palindrome {
    public static boolean palindrome(LinkedListNode node) {
        // create inversed LL
        // compare inversed with node
        LinkedListNode reversed = reverse(node);

        while (node != null) {
            if (node.data != reversed.data) {
                return false;
            } else {
                node = node.next;
                reversed = reversed.next;
            }
        }

        return true;
    }

    private static LinkedListNode reverse(LinkedListNode node) {
        Stack<Integer> stack = new Stack<>();
        LinkedListNode current = node;

        while (current != null) {
            stack.add(current.data);
            current = current.next;
        }

        return fromStack(stack);
    }

    private static LinkedListNode fromStack(Stack<Integer> stack) {
        LinkedListNode start = null;
        LinkedListNode end = null;

        while(!stack.isEmpty()) {
            LinkedListNode node = new LinkedListNode(stack.pop());
            if (start == null) {
                start = node;
                end = node;
            } else {
                end.next = node;
                end = node;
            }
        }

        return start;
    }
}
