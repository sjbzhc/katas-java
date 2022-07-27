package leetcode;

import java.util.PriorityQueue;

public class MaximumAverageRatioPass {
    class Data {
        double pass = -1;
        double total = -1;

        public double ratio() {
            if (total == -1) return -1;
            return pass / total;
        }

        public double potential() {
            return ((pass + 1.0) / (total + 1.0)) - (pass / total);
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> Double.compare(b.potential(), a.potential()));

        for (int[] c : classes) {
            Data d = new Data();
            d.pass = c[0];
            d.total = c[1];
            pq.offer(d);
        }

        while (extraStudents > 0) {
            extraStudents--;
            Data d = pq.poll();
            d.pass++;
            d.total++;
            pq.offer(d);
        }

        double sum = 0.0;

        while (!pq.isEmpty()) {
            sum += pq.poll().ratio();
        }

        return sum / classes.length;
    }
}
