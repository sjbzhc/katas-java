package leetcode;

import java.util.Stack;

/*
 * Time: O(n)
 * Space: O(n)
* */

public class DailyTemperatures {
    class Pair {
        int index;
        int temperature;

        public Pair(int index, int temperature) {
            this.index = index;
            this.temperature = temperature;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack();
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i=0; i<n; i++) {
            int temperature = temperatures[i];

            // since we pop all elements that have a smaller temperature than the current one, we have
            // a monotinic decreasing stack. We know that it will always be lower than the previous value
            while (!stack.isEmpty() && temperature > stack.peek().temperature) {
                Pair p = stack.pop();
                res[p.index] = i - p.index;
            }
            stack.push(new Pair(i, temperature));

        }
        return res;
    }
}
