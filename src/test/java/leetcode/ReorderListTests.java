package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ReorderListTests {
    @Test
    public void test() {
        ReorderList rl = new ReorderList();

        ListNode ln = new ListNode(0);
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);

        ln.next = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        rl.reorderListMemory(ln);

        Assertions.assertThat(ln.toString()).isEqualTo("04132");

    }
}
