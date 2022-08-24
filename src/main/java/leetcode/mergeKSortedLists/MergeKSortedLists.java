package leetcode.mergeKSortedLists;

import leetcode.MergeTwoSortedLists;

import java.util.PriorityQueue;

/*
* Time: O(n log k)
* Space: O(n)
* */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode pointer = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode ln : lists) {
            if (ln != null) pq.add(ln);
        }

        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            if (head == null) {
                head = new ListNode(current.val);
                pointer = head;
            } else {
                ListNode newNode = new ListNode(current.val);
                head.next = newNode;
                head = newNode;
            }

            current =  current.next;
            if (current != null) pq.add(current);

        }
        return pointer;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if(lists.length == 0) return null;

        int interval = 1;
        while(interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }
}
