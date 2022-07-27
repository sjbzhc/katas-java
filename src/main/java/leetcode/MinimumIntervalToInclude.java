package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumIntervalToInclude {

    class Data {
        int intervalSize;
        int startValue;

        public Data(int intervalSize, int startValue) {
            this.intervalSize = intervalSize;
            this.startValue = startValue;
        }
    }
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (x, y)-> {
            if(x[1] != y[1])
                return y[1]- x[1];
            return y[0]-x[0];
        });

        int[][] queryWithIndex = new int[queries.length][2];
        for(int i=0 ;i < queryWithIndex.length; i++){
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }

        Arrays.sort(queryWithIndex,(x,y) -> y[0] - x[0]);
        PriorityQueue<Data> pq = new PriorityQueue<>((x, y)->x.intervalSize - y.intervalSize);

        int[] result = new int[queries.length];
        int j = 0;
        for(int i=0; i < queryWithIndex.length; i++) {
            int query  = queryWithIndex[i][0];
            int queryIndex = queryWithIndex[i][1];
            // We add to heap if the intervals end is after the query
            while (j < intervals.length && intervals[j][1] >= query) {
                pq.offer(new Data(intervals[j][1] - intervals[j][0] + 1, intervals[j][0]));
                j++;
            }
            while (pq.size() > 0 && pq.peek().startValue > query) {
                pq.poll();
            }
            if (pq.size() == 0) result[queryIndex] = -1;
            else result[queryIndex] = pq.peek().intervalSize;
        }
        return result;
    }
}
