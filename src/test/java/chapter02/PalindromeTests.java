package chapter02;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PalindromeTests {

    @Test
    public void palindrome_false() {
        LinkedListNode list = LinkedListNode.fromList(List.of(1,2,3));
        Assertions.assertThat(Palindrome.palindrome(list)).isFalse();
    }

    @Test
    public void palindrome_true() {
        LinkedListNode list = LinkedListNode.fromList(List.of(1,2,3,2,1));
        Assertions.assertThat(Palindrome.palindrome(list)).isTrue();
    }

    @Test
    public void palindrome_true_2() {
        LinkedListNode list = LinkedListNode.fromList(List.of(1,2,3,2,1));
        Assertions.assertThat(Palindrome2.palindrome(list)).isTrue();
    }
}
