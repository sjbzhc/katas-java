package leetcode.addTwoNumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // validate
        int carry = 0;

        int length1 = getLength(l1);
        int length2 = getLength(l2);
        ListNode longer;
        ListNode shorter;
        ListNode result = null;
        ListNode resultPointer = null;

        if (length1 >= length2) {
        longer = l1;
        shorter = l2;
        } else {
            longer = l2;
            shorter = l1;
        }
        int remainder = 0;
        boolean hasRemaninder = false;

        while (longer != null) {
            int currentSum = 0;
            if (shorter != null) {
                currentSum += shorter.val;
                shorter = shorter.next;
            }
            currentSum += longer.val;
            currentSum += carry;
            carry = 0;
            ListNode currentNode = new ListNode();

            if (currentSum / 10 > 0) {
                carry = 1;
                currentNode.val = currentSum % 10;
            } else {
                currentNode.val = currentSum;
            }

            if (result == null) {
                result = currentNode;
                resultPointer = result;
            } else {
                result.next = currentNode;
                result = currentNode;
            }
            longer = longer.next;
            if (longer == null) {
                if (currentSum / 10 > 0) {
                    hasRemaninder = true;
                    remainder = currentSum / 10;
                }
            }
        }

        if (hasRemaninder) {
            ListNode lastNode = new ListNode(remainder);
            result.next = lastNode;
        }

        return resultPointer;
    }

    private int getLength(ListNode l1) {
        int res = 0;
        while (l1 != null) {
            res++;
            l1 = l1.next;
        }
        return res;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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
                result.next = new ListNode(unit);
                result = result.next;
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
