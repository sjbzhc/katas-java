package leetcode;

import leetcode.addTwoNumbers.AddTwoNumbers;
import leetcode.addTwoNumbers.ListNode;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class AddTwoNumbersTests {
    @Test
    public void add_two_numbers() {
        AddTwoNumbers at = new AddTwoNumbers();
        ListNode l1_2 = new ListNode(2);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_2.next = l1_4;
        l1_4.next = l1_3;

        ListNode l2_5 = new ListNode(5);
        ListNode l2_6 = new ListNode(6);
        ListNode l2_4 = new ListNode(4);
        l2_5.next = l2_6;
        l2_6.next = l2_4;

        ListNode r_7 = new ListNode(7);
        ListNode r_0 = new ListNode(0);
        ListNode r_8 = new ListNode(8);
        r_7.next = r_0;
        r_0.next = r_8;

        Assertions.assertThat(at.addTwoNumbers(l1_2, l2_5).toString()).isEqualTo(r_7.toString());
    }

    @Test
    public void add_two_numbers_2() {
        AddTwoNumbers at = new AddTwoNumbers();
        ListNode l1_2 = new ListNode(0);

        ListNode l2_5 = new ListNode(0);

        ListNode r_7 = new ListNode(0);

        Assertions.assertThat(at.addTwoNumbers(l1_2, l2_5).toString()).isEqualTo(r_7.toString());
    }

    @Test
    public void add_two_numbers_3() {
        AddTwoNumbers at = new AddTwoNumbers();
        ListNode l1_1 = new ListNode(9);
        ListNode l1_2 = new ListNode(9);
        ListNode l1_3 = new ListNode(9);
        ListNode l1_4 = new ListNode(9);
        ListNode l1_5 = new ListNode(9);
        ListNode l1_6 = new ListNode(9);
        ListNode l1_7 = new ListNode(9);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;
        l1_5.next = l1_6;
        l1_6.next = l1_7;


        ListNode l2_1 = new ListNode(9);
        ListNode l2_2 = new ListNode(9);
        ListNode l2_3 = new ListNode(9);
        ListNode l2_4 = new ListNode(9);
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;

        ListNode r_1 = new ListNode(8);
        ListNode r_2 = new ListNode(9);
        ListNode r_3 = new ListNode(9);
        ListNode r_4 = new ListNode(9);
        ListNode r_5 = new ListNode(0);
        ListNode r_6 = new ListNode(0);
        ListNode r_7 = new ListNode(0);
        ListNode r_8 = new ListNode(1);
        r_1.next = r_2;
        r_2.next = r_3;
        r_3.next = r_4;
        r_4.next = r_5;
        r_5.next = r_6;
        r_6.next = r_7;
        r_7.next = r_8;

        Assertions.assertThat(at.addTwoNumbers(l1_1, l2_1).toString()).isEqualTo(r_1.toString());
    }
}
