package leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */

public class CarFleet {
    class Pair {
        int position;
        int speed;

        public Pair(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pairs = new Pair[n];
        for (int i=0; i<n;i++) pairs[i] = new Pair(position[i], speed[i]);
        Arrays.sort(pairs, (a, b) -> b.position - a.position);

        // Keeps time of arrival
        Stack<Integer> stack = new Stack<>();

        for (Pair p : pairs) {
            stack.push((target - p.position) / p.speed);
            if (stack.size() >= 2 && stack.get(stack.size() - 1) <= stack.get(stack.size() - 2)) stack.pop();
        }
        return stack.size();
    }
}
