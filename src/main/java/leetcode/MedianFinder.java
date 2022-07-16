package leetcode;

import java.util.PriorityQueue;

/*
* Time: O(log n)
* Space: O(n)
* */
public class MedianFinder {

    public PriorityQueue<Integer> left;
    public PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a);
        right = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        left.offer(num);

        // 2 conditions need to be maintained: biggest element in left is <= smallest element in right
        if (!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
            right.offer(left.poll());
        }

        // each pq should contain no more than n/2 + 1 elements (next 2 ifs handle that)
        if (left.size() > right.size() + 1) right.offer(left.poll());
        if (right.size() > left.size() + 1) left.offer(right.poll());


    }

    public double findMedian() {
        if (left.size() > right.size()) return left.peek();
        if (right.size() > left.size()) return right.peek();

        return (left.peek() + right.peek()) / 2.0;
    }
}
