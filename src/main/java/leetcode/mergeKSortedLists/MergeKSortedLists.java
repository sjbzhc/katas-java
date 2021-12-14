package leetcode.mergeKSortedLists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return new ListNode();
        ListNode head = null;
        ListNode tail = null;

        Comparator<ListNode> comparator = (o1, o2) -> o1.val - o2.val;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(comparator);

        for (ListNode ln : lists) {
            pq.add(ln);
        }

        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            if (head == null) {
                head = new ListNode(current.val);
                tail = head;
            } else {
                ListNode newNode = new ListNode(current.val);
                head.next = newNode;
                head = newNode;
            }
            current =  current.next;
            if (current != null) {
                pq.add(current);
            }
        }

        return tail;
    }
}
