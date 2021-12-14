package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates2 {
    public void wallsAndGates(int[][] room) {
        int ROWS = room.length;
        int COLS = room[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int r=0;r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (room[r][c] == 0) {
                    queue.add(new int[]{r, c});
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

                if (newRow >= ROWS || newRow < 0 || newCol >= COLS || newCol < 0 || room[newRow][newCol] != Integer.MAX_VALUE) continue;

                room[newRow][newCol] = room[row][col] + 1;
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
