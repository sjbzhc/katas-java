package leetcode;

import java.util.PriorityQueue;

/*
* By using a min pq, we are guaranteed to be in the path with the lowest max height. If for example we
* have for a path a height of 100 in the second node, it will go to the back of the pq. In the meantime,
* paths with lower values will further develop, reaching the end and ignoring the ones with big values.
*
* Time: O(n2 log n) n2 expand nodes, log n for heap
* Space: O(n2)
* */

public class SwimInWater {

    class Data {
        int row;
        int col;
        int height;

        public Data(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> a.height - b.height);


        pq.add(new Data(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Data current = pq.poll();
            int row = current.row;
            int col = current.col;
            int height = current.height;
            visited[row][col] = true;

            if (row == ROWS - 1 && col == COLS - 1) return height;
            int[] rowOffsets = {-1, 0, 1, 0};
            int[] colOffsets = {0, -1, 0, 1};

            for (int d=0; d<4; d++) {
                int newRow = row + rowOffsets[d];
                int newCol = col + colOffsets[d];

                if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0 || visited[newRow][newCol]) continue;
                pq.add(new Data(newRow, newCol, Math.max(height, grid[newRow][newCol])));
            }
        }

        return -1;
    }
}
