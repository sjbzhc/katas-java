package leetcode;

import java.util.*;

/*
* Time: O(n log n) due to doubling of speed
* Space: O(n log n) nodes in graph match time
* */

public class RaceCar {

    class Data {
        int position;
        int speed;
        int count;

        public Data(int position, int speed, int count) {
            this.position = position;
            this.speed = speed;
            this.count = count;
        }
    }
    public int racecar(int target) {
        Set<String> visited = new HashSet<>();
        String k = 0 + "#" + 1;
        visited.add(k);
        LinkedList<Data> q = new LinkedList<>();
        q.add(new Data(0, 1, 0));

        while (!q.isEmpty()) {
            Data current = q.poll();
            int position = current.position;
            int speed = current.speed;
            int count = current.count;

            // Move forward
            if (position + speed == target) return count + 1;

            String startingKey = (position + speed) + "#" + (speed * 2);
            if (!visited.contains(startingKey)) {
                q.offer(new Data(position + speed, speed * 2, count + 1));
                visited.add(startingKey);
            }

            // Need to reverse speed
            if (speed > 0) {
                String reverseKey = position + "#" + -1;
                if (!visited.contains(reverseKey) && position + speed > target) {
                    q.offer(new Data(position, -1, count + 1));
                    visited.add(reverseKey);
                }
            // Speed is negative, need to go positive
            } else {
                String restartKey = position + "#" + 1;
                if (!visited.contains(restartKey) && position + speed < target) {
                    q.offer(new Data(position, 1, count + 1));
                    visited.add(restartKey);
                }
            }
        }
        return -1;
    }
}
