package chapter02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinkedListNodeTests {

    @Test
    public void linked_list_node() {
        LinkedListNode node = new LinkedListNode(1);
        Assertions.assertEquals(node.data, 1);
    }

    @Test
    public void from_array() {
        Assertions.assertEquals(LinkedListNode.fromList(List.of(1,2,3)).toString(), "123");
        Assertions.assertEquals(LinkedListNode.fromList(List.of(1,2,3,4,5,6)).toString(), "123456");
    }

    @Test
    public void remove_dups() {
        LinkedListNode list = LinkedListNode.fromList(List.of(1, 2, 3, 4, 1, 2, 3));
        RemoveDups.removeDups(list);
        Assertions.assertEquals(list.toString(), "1234");
    }

    @Test
    public void remove_dups2() {
        LinkedListNode list = LinkedListNode.fromList(List.of(1, 2, 3, 4, 1, 2, 3));
        RemoveDups.removeDups2(list);
        Assertions.assertEquals(list.toString(), "1234");
    }

    @Test
    public void partition() {
        LinkedListNode list = LinkedListNode.fromList(List.of(3,5,8,5,10,2,1));
        Assertions.assertEquals(Partition.partition(list, 5).toString(), "32158510");
    }
}
