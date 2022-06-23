package leetcode;

public class ReverseDoublyLinkedList {

    class Node {
        Node next;
        Node prev;
    }

    Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }
}
