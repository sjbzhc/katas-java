package leetcode;

import java.util.PriorityQueue;

/*
 * Time: O(n log n)
 * Space: O(n)
 * When simply adding, we add through the minPq and it does not do anything.
 * The minPq is useful when the get method is used. It ensures that for any record
 * we get back in circulation, it will be returned after any other records with lower
 * score have been processed.
 * */


public class SORTracker {

    class Node {
        String name;
        int score;

        public Node(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
    PriorityQueue<Node> maxPq;
    PriorityQueue<Node> minPq;

    public SORTracker() {
        minPq = new PriorityQueue<>((a, b) -> a.score == b.score ? b.name.compareTo(a.name) : a.score - b.score);
        maxPq = new PriorityQueue<>((a, b) -> a.score == b.score ? a.name.compareTo(b.name) : b.score - a.score);
    }

    public void add(String name, int score) {
        minPq.add(new Node(name, score));
        maxPq.add(minPq.poll());
    }

    public String get() {
        String ans = maxPq.peek().name;
        minPq.add(maxPq.poll());
        return ans;
    }
}
