package chapter02;

import java.util.Stack;

public class Palindrome2 {
    public static boolean palindrome(LinkedListNode list) {
        LinkedListNode reversed = reverse(list);
        return false;
    }

    private static LinkedListNode reverse(LinkedListNode list) {
        print(list);
        Stack<Integer> stack = new Stack<>();

        while (list != null) {
            stack.add(list.data);
            list = list.next;
        }

        LinkedListNode head = null;
        LinkedListNode tail = null;

        while (!stack.isEmpty()) {
            LinkedListNode current = new LinkedListNode(stack.pop());
            if (head == null) {
                head = current;
                tail = head;
            } else {
                tail.next = current;
                tail = current;
            }
        }

        print(head);


        return head;
    }

    private static void print(LinkedListNode list) {
        StringBuilder sb = new StringBuilder();
        while (list != null) {
            sb.append(list.data);
            list = list.next;
        }

        System.out.println(sb.toString());
    }
}
