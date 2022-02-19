package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
* Time: O(m*n)
* Space: O(m*n)
* The trick is to start several BFS at the same time and to start from the gates.
*
* Starting several BFS at the same time means just adding all gates to the queue before starting the loop.
*
* This means that after the first initial n gates are processed, all of it's neighbours will be processed in the room.
* */

public class WallsAndGates {
    public void wallsAndGates(int[][] room) {
        int ROWS = room.length;
        int COLS = room[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int r=0;r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (room[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[] rowOffsets = {-1,0,1,0};
        int[] colOffsets = {0,-1,0,1};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            for (int d=0;d<4;d++) {
                int newRow = row + rowOffsets[d];
                int newCol = col + colOffsets[d];

                if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS || room[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                room[newRow][newCol] = room[row][col] + 1;
                queue.offer(new int[]{newRow, newCol});
            }

        }

    }
}
