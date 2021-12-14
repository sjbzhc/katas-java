package chapter02;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class LinkedListTests {
    @Test
    public void linked_list_ascending() {
        List<Integer> list = List.of(1,2,3);
        LinkedListNode head = null;
        LinkedListNode tail = null;
        for (int i : list) {
            LinkedListNode current = new LinkedListNode(i);
            if (head == null) {
                head = current;
                tail = current;
            } else {
                tail.next = current;
                tail = current;
            }
        }

        System.out.println(head.toString());
    }

    @Test
    public void linked_list_descending() {
        List<Integer> list = List.of(1,2,3);
        LinkedListNode head = null;
        for (int i : list) {
            LinkedListNode current = new LinkedListNode(i);
            if (head == null) {
                head = current;
            } else {
                current.next = head;
                head = current;
            }
        }

        System.out.println(head.toString());
    }
}
