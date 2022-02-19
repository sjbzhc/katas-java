package leetcode;

import leetcode.addTwoNumbers.ListNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ReverseKGroupTests {
    @Test
    public void reverse_k_group() {
        ReverseKGroup rk = new ReverseKGroup();
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        Assertions.assertThat(rk.reverseKGroup(ln1, 2).toString()).isEqualTo("21435");
    }
}
