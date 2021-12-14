package chapter02;

public class Intersection {

    public boolean intersection(LinkedListNode n1, LinkedListNode n2) {
        /*
        * Find length of both
        * Get delta
        * Advance the longer by delta
        * start moving forward until finding a match, or return false
        * */

        int l1 = getLength(n1);
        int l2 = getLength(n2);
        int delta = Math.abs(l1 - l2);
        if ((l1 - l2) > 0) n1 = advanceN(n1, delta);
        else if ((l2 - l1) > 0) n2 = advanceN(n2, delta);

        while(n1 != null) {
            if(n1 == n2) return true;
            else {
                n1 = n1.next;
                n2 = n2.next;
            }
        }

        return false;
    }

    public int getLength(LinkedListNode node) {
        int counter = 0;
        LinkedListNode current = node;

        while(current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    private LinkedListNode advanceN(LinkedListNode node, int advance) {
        while(advance > 0) {
            node = node.next;
            advance--;
        }
        return node;
    }
}
