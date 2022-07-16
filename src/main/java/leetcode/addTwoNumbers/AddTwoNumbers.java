package leetcode.addTwoNumbers;

/*
* Time: O(n)
* Space: O(n)
* */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // validate
        ListNode result = null;
        ListNode pointer = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;

            int unit = sum % 10;
            carry = sum / 10;
            if (result == null) {
                result = new ListNode(unit);
                pointer = result;
            } else {
                ListNode newNode = new ListNode(unit);
                result.next = newNode;
                result = newNode;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return pointer;
    }
}
