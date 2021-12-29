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
}
