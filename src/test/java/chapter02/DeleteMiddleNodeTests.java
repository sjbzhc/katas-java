package chapter02;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class DeleteMiddleNodeTests {

    @Test
    public void delete_middle_node() {
        DeleteMiddleNode delete = new DeleteMiddleNode();

        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        delete.deleteMiddleNode(node2);

        Assertions.assertThat(node1.toString()).isEqualTo("134");
    }
}
