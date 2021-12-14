package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class DequeTests {

    @Test
    public void deque_tests_modify_default() {
        // Behaves as a queue
        Deque<Integer> dq = new ArrayDeque<>();

        dq.add(1);
        dq.add(2);
        dq.add(3);

        System.out.println(dq);
        // [1, 2, 3]

        dq.remove();
        System.out.println(dq);
        // [2, 3]
    }

    @Test
    public void deque_tests_modify_add_last_remove_first() {
        // Behaves as a queue.
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);

        System.out.println(dq);
        // [1, 2, 3]

        dq.removeFirst();
        System.out.println(dq);
        // [2, 3]
    }

    @Test void queue_tests() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q);
        // [1, 2, 3]

        q.poll();

        System.out.println(q);
        // [2, 3]
    }

    @Test
    public void deque_tests_modify_add_first_remove_last() {
        // Behaves as a queue, but in the other direction.
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);

        System.out.println(dq);
        // [3, 2, 1]

        dq.removeLast();
        System.out.println(dq);
        // [3, 2]
    }

    @Test
    public void deque_tests_modify_last() {
        // Behaves as a stack
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);

        System.out.println(dq);
        // [1, 2, 3]

        dq.removeLast();
        System.out.println(dq);
        // [1, 2]
    }

    @Test
    public void stack_tests() {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s);
        // [1, 2, 3]

        s.pop();

        System.out.println(s);
        // [1, 2]
    }

    @Test
    public void deque_tests_modify_first() {
        // Behaves as a stack, but from the other direction
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);

        System.out.println(dq);
        // [3, 2, 1]

        dq.removeFirst();
        System.out.println(dq);
        // [2, 1]
    }

}
