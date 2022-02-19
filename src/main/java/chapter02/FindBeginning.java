package chapter02;

/*
* Time: O(n)
* Space: O(1)
* */
public class FindBeginning {
    public LinkedListNode findBeginning(LinkedListNode n1) {
        LinkedListNode slow = n1;
        LinkedListNode fast = n1;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }

        slow = n1;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
