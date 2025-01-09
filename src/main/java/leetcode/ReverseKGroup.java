package leetcode;

import leetcode.addTwoNumbers.ListNode;

/*
* Works like weaving.
*
* The reverse function will change the position of the nodes, but head will still point to the first element (in the
* reversed list it's now the last element).
*
* That's why we can say head.next = reverseKGroup(p, k)
* */

/*
* Time: O(n)
* Space: O(n/k)
* */

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode p = head;

        // Create a pointer to after k-sequence
        while (p != null && count < k) {
            p = p.next;
            count++;
        }

        // If we were able to move more than k, reverse
        if (count == k) {
            ListNode reversedHead = reverse(head, k);
            head.next = reverseKGroup(p, k);
            return reversedHead;
        }

        return head;
    }

    ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            k--;
        }

        return prev;
    }
}
