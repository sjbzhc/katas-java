package chapter02;

import org.junit.Test;
import org.assertj.core.api.Assertions;


public class IntersectionTests {

    @Test
    public void intersection_true() {
        /*
        *      1-2
        *           3-4
        * 10-11-12
        * */

        LinkedListNode node10 = new LinkedListNode(10);
        LinkedListNode node11 = new LinkedListNode(11);
        LinkedListNode node12 = new LinkedListNode(12);

        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        node12.next = node3;
        node11.next = node12;
        node10.next = node11;

        Intersection intersection = new Intersection();
        Assertions.assertThat(intersection.intersection(node1, node10)).isTrue();
    }

    @Test
    public void intersection_false() {
        /*
         *      1-2
         *           3-4
         * 10-11-12
         * */

        LinkedListNode node10 = new LinkedListNode(10);
        LinkedListNode node11 = new LinkedListNode(11);
        LinkedListNode node12 = new LinkedListNode(12);

        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        node11.next = node12;
        node10.next = node11;

        Intersection intersection = new Intersection();
        Assertions.assertThat(intersection.intersection(node1, node10)).isFalse();
    }

    @Test
    public void intersection_length() {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        Intersection intersection = new Intersection();

        Assertions.assertThat(intersection.getLength(node1)).isEqualTo(4);
    }


}
