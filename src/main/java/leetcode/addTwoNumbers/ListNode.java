package leetcode.addTwoNumbers;

public class ListNode {
   public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode root = this;
        while (root != null) {
            sb.append(root.val);
            root = root.next;
        }
        return sb.toString();
    }
}
