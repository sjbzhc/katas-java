package leetcode;

import leetcode.mergeKSortedLists.ListNode;
import leetcode.mergeKSortedLists.MergeKSortedLists;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class MergeKSortedListsTests {
    @Test
    public void merge_k_sorted_lists() {
        MergeKSortedLists ms = new MergeKSortedLists();

        ListNode l15 = new ListNode(5);
        ListNode l14 = new ListNode(4, l15);
        ListNode l11 = new ListNode(1, l14);

        ListNode l24 = new ListNode(4);
        ListNode l23 = new ListNode(3, l24);
        ListNode l21 = new ListNode(1, l23);

        ListNode l36 = new ListNode(6);
        ListNode l32 = new ListNode(2, l36);

        ListNode r6 = new ListNode(6);
        ListNode r5 = new ListNode(5, r6);
        ListNode r4 = new ListNode(4, r5);
        ListNode r42 = new ListNode(4, r4);
        ListNode r3 = new ListNode(3, r42);
        ListNode r2 = new ListNode(2, r3);
        ListNode r1 = new ListNode(1, r2);
        ListNode r11 = new ListNode(1, r1);

        ListNode[] list = {l11, l21, l32};

        Assertions.assertThat(ms.mergeKLists(list).toString()).isEqualTo(r11.toString());

    }

    @Test
    public void merge_k_sorted_lists_2() {
        MergeKSortedLists ms = new MergeKSortedLists();

        ListNode l15 = new ListNode(5);
        ListNode l14 = new ListNode(4, l15);
        ListNode l11 = new ListNode(1, l14);

        ListNode l24 = new ListNode(4);
        ListNode l23 = new ListNode(3, l24);
        ListNode l21 = new ListNode(1, l23);

        ListNode l36 = new ListNode(6);
        ListNode l32 = new ListNode(2, l36);

        ListNode r6 = new ListNode(6);
        ListNode r5 = new ListNode(5, r6);
        ListNode r4 = new ListNode(4, r5);
        ListNode r42 = new ListNode(4, r4);
        ListNode r3 = new ListNode(3, r42);
        ListNode r2 = new ListNode(2, r3);
        ListNode r1 = new ListNode(1, r2);
        ListNode r11 = new ListNode(1, r1);

        ListNode[] list = {l11, l21, l32};

        Assertions.assertThat(ms.mergeKListsDivideAndConquer(list).toString()).isEqualTo(r11.toString());

    }
}
