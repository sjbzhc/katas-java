package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
* We use {-1,-1} as a delimiter for each level of the bfs recursion.
*
* We add to the queue only rotten oranges, which stem either from the first sweep, or as 'children' of their 'parent'
* rotten oranges, e.g. rotting process. After the initial sweep, no old-rotten orange is added, only the ones that were
* 1 directly adjacent to a 2, and therefore turn into a 2
*
* First we add all originally rotten oranges to the queue. Additionally we count the fresh oranges, as we want to know if all
* rotted in the end.
*
* After adding all rotten oranges to the queue, we delimit with {-1,-1}
*
* We then do bfs. If the current coordinates are not a deliminator, we rot the neighboring oranges of the current
* rotten orange, adding them to the queue. This also reduces the freshOranges count.
*
* If it's a delimiter, it means the current timeframe has elapsed, so we increase elapsedTime. We also check if the
* queue is not empty. If it is not empty, we add an additional deliminator. This can only be done here as here is where
* we know that the current time ended.
* */

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int freshOranges = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    int[] pair = {r, c};
                    queue.offer(pair);
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        queue.offer(new int[]{-1,-1});
        int minutesElapsed = -1;

        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,-1,0,1};

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];

            // Current point is not a delimiter
            if (row != -1) {
                for (int d = 0;d<4;d++) {
                    int neighborRow = row + rowOffset[d];
                    int neighborCol = col + colOffset[d];

                    if (neighborRow >= 0 && neighborRow < ROWS &&
                            neighborCol >=0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            queue.offer(new int[]{neighborRow, neighborCol});
                        }
                    }
                }
            // if it's a delimiter it means the current level is done
            } else {
                minutesElapsed++;
                if (!queue.isEmpty()) {
                    queue.offer(new int[]{-1,-1});
                }
            }
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }

}
