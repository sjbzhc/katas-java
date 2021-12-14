package chapter02;

import java.util.HashSet;

public class RemoveDups {

    public static void removeDups(LinkedListNode node) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while(node != null) {
            if (!set.contains(node.data)) {
                set.add(node.data);
                previous = node;
            } else {
                previous.next = node.next;
            }
            node = node.next;
        }
    }

    public static void removeDups2(LinkedListNode node) {
        LinkedListNode current = node;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
