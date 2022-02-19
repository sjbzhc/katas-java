package leetcode;

import leetcode.addTwoNumbers.ListNode;

public class ReverseLinkedList {
    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev; // actual reversal
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /*
    * base cases: the node is null or it has no next node, then no need to reverse anything
    *
    * node: 1->2->3
    * newHead: points to the head of an inverted ll. Since we send to it node.next as argument, it returns:
    * 3->2
    *
    * node is still pointing at 1, and node.next still points to 2, which is at the end of newHead
    * so doing node.next.next means setting the next pointer of 2 (in this case to head = 1)
    * 3->2->1
    *
    * finally, we set head.next to null, since it is now the end of the list. Otherwise, we have a cycle
    *
    * */
    public ListNode reverseRecursive(ListNode node) {
        if (node == null) return node;

        if (node.next == null) return node;

        ListNode newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}
