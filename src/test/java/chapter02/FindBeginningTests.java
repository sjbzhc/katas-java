package chapter02;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FindBeginningTests {
    @Test
    public void find_beginning() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        LinkedListNode n6 = new LinkedListNode(6);
        LinkedListNode n7 = new LinkedListNode(7);
        LinkedListNode n8 = new LinkedListNode(8);
        LinkedListNode n9 = new LinkedListNode(9);
        LinkedListNode n10 = new LinkedListNode(10);
        LinkedListNode n11 = new LinkedListNode(11);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n4.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n4;

        FindBeginning fb = new FindBeginning();

        Assertions.assertThat(fb.findBeginning(n1).data).isEqualTo(n4.data);
    }
}
