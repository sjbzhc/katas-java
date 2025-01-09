package leetcode;

import java.util.*;

public class RaceCar {

    private Map<String, Integer> memo = new HashMap<>();

    public int racecarRec(int target) {
        return helper(0, 1, target);
    }

    private int helper(int position, int speed, int target) {
        if (position == target) return 0;

        String key = position + "#" + speed;
        if (memo.containsKey(key)) return memo.get(key);

        // 1. Accelerate: Move in the same direction with increased speed
        int newPosition = position + speed;
        int newSpeed = speed * 2; // Accelerate, double the speed

        // If we're overshooting the target, try reducing the speed (reversing)
        int accelerateResult = helper(newPosition, newSpeed, target) + 1;

        // 2. Reverse: Reverse the direction (reset the speed to -1)
        int reverseResult = helper(position, speed > 0 ? -1 : 1, target) + 1;

        // The result is the minimum of accelerating or reversing
        int result = Math.min(accelerateResult, reverseResult);

        memo.put(key, result);
        return result;
    }

    /*
     * Time: O(n log n) due to doubling of speed
     * Space: O(n log n) nodes in graph match time
     * */

    class Data {
        int position;
        int speed;
        int count;
        public Data(int p, int s, int c) {
            position = p;
            speed = s;
            count = c;
        }
    }
    public int racecar(int target) {
        Set<String> cache = new HashSet<>();
        String k = 0 + "#" + 1;
        cache.add(k);
        LinkedList<Data> q = new LinkedList<>();
        q.add(new Data(0, 1, 0));

        while (!q.isEmpty()) {
            Data d = q.poll();
            int position = d.position;
            int speed = d.speed;
            int count = d.count;

            if (position + speed == target) return count + 1;

            String nextKey = (position + speed) + "#" + (speed * 2);
            if (!cache.contains(nextKey)) {
                q.offer(new Data(position + speed, speed * 2, count+1));
                cache.add(nextKey);
            }

            // Need to reverse speed
            String reverseKey = position + "#" + -1;
            if (!cache.contains(reverseKey) && speed > 0 && position + speed > target) {
                q.offer(new Data(position, -1, count + 1));
                cache.add(reverseKey);

            }

            // Speed is negative, need to restart
            String restartKey = position + "#" + 1;
            if (!cache.contains(restartKey) && speed < 0 && position + speed < target) {
                q.offer(new Data(position, 1, count + 1));
                cache.add(restartKey);
            }
        }

        return -1;
    }
}
