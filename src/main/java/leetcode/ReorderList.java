package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // advance slow until end of first half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // second after first half
        ListNode second = slow.next;
        //separate lists
        slow.next = null;

        // reverse second list
        ListNode prev = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        // set pointers for first and second
        ListNode first = head;
        second = prev;

        // length of second always <= first
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    // test later
    public void reorderListMemory(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        ListNode res = head;

        int leftCounter = 0;
        int rightCounter = 0;
        int counter = 0;

        boolean addFromLeft = true;

        while (counter < list.size() - 1) {
            if (addFromLeft) {
                if (counter == 0) {
                    res = list.get(0);
                } else {
                    res.next = list.get(leftCounter);
                }
                leftCounter++;
            } else {
                res.next = list.get(list.size() - 1 - rightCounter);
                rightCounter++;
            }
            addFromLeft = !addFromLeft;
            counter++;
        }
    }
}
