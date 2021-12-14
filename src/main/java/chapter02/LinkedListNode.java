package chapter02;

import java.util.List;

public class LinkedListNode {
    int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public static LinkedListNode fromList(List<Integer> list) {
        LinkedListNode right = null;
        LinkedListNode left = null;
        for(int i = 0; i < list.size(); i++) {
            LinkedListNode current = new LinkedListNode(list.get(i));
            if (right == null) {
                right = current;
                left = current;
            }
            else {
                right.next = current;
                right = current;
            }
        }
        return left;
    }

    public LinkedListNode insertAfter(LinkedListNode node, int i) {
        if (node == null) {
            return new LinkedListNode(i);
        } else {
            node.next = new LinkedListNode(i);
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode node = this;
        while (node != null) {
            sb.append(node.data);
            node = node.next;
        }

        return sb.toString();
    }
}
