package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges2 {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = -1;
        int oranges = 0;
        for (int r = 0;r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (grid[r][c] == 1) {
                    oranges++;
                }
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        queue.offer(new int[]{-1, -1});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size;i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentCol = current[1];
                int[] rowOffsets = {-1,0,1,0};
                int[] colOffsets = {0,-1,0,1};
                for (int d=0;d<4;d++) {
                    int newRow = currentRow + rowOffsets[d];
                    int newCol = currentCol + colOffsets[d];

                    if (newCol >= COLS || newCol < 0 || newRow >= ROWS || newRow < 0) continue;

                    if (grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        oranges--;
                    }
                }
            }
            count++;

        }

        if (oranges == 0) {
            return count;
        }
        return -1;
    }
}
