package leetcode;

import leetcode.addTwoNumbers.ListNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ReverseLinkedListTests {
    @Test
    public void reverse_linked_list() {
        ReverseLinkedList rl = new ReverseLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        Assertions.assertThat(rl.reverse(n1).toString()).isEqualTo("321");

    }

    @Test
    public void reverse_linked_list_recursive() {
        ReverseLinkedList rl = new ReverseLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        Assertions.assertThat(rl.reverseRecursive(n1).toString()).isEqualTo("321");

    }
}
