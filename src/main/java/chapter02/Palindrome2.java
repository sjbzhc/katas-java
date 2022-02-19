package chapter02;

import java.util.Stack;

public class Palindrome2 {
    public static boolean palindrome(LinkedListNode node) {
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

    private static LinkedListNode reverse(LinkedListNode list) {
        LinkedListNode tail = null;
        LinkedListNode head = null;

        while (list != null) {
            if (head == null) {
                head = new LinkedListNode(list.data);
                tail = head;
            } else {
                LinkedListNode newNode = new LinkedListNode(list.data);
                newNode.next = tail;
                tail = newNode;
            }
            list = list.next;
        }

        return tail;

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
