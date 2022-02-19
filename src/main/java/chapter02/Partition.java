package chapter02;

/*
* Time: O(n)
* Space: O(n)
* */

public class Partition {
    public static LinkedListNode partition(LinkedListNode node, int i) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < i) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = node;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = node;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
