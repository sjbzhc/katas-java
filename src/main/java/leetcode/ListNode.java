package leetcode;


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode current = this;

        while (current != null) {
            sb.append(val);
            current = current.next;
        }

        return sb.toString();
    }
}

