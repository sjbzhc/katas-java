package leetcode;

import java.util.*;

/*
* Time: O(n)
* Space: O(n)
* */
public class TaskScheduler {

    class Pair {
        int count;
        int readyAt;

        public Pair(int count, int readyAt) {
            this.count = count;
            this.readyAt = readyAt;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : freq.values()) pq.offer(i);
        LinkedList<Pair> q = new LinkedList<>();

        int time = 0;

        // we only have in the pq tasks that are ready to be picked
        // Queue is a buffer that holds them until they are ready
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if(!pq.isEmpty()) {
                // we are placing one of the elements of this count
                int count = pq.poll() - 1;
                if (count > 0) {
                    // we add it to the queue, for pick-up at time + n
                    q.add(new Pair(count, time + n));
                }
            }
            if (!q.isEmpty() && q.getFirst().readyAt == time) {
                pq.offer(q.pollFirst().count);
            }
        }
        return time;
    }
}
