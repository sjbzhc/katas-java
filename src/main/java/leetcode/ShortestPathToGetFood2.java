package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood2 {
    int ROWS;
    int COLS;
    public int getFood(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int res = 0;

        int[][] visited = new int[ROWS][COLS];
        Queue<int[]> queue = new LinkedList<>();

        for (int r =0; r<ROWS;r++) {
            for (int c=0;c<COLS;c++) {
                if (grid[r][c] == '*') {
                    queue.add(new int[] {r, c});
                    visited[r][c] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] coordinates = queue.poll();
                int row = coordinates[0];
                int col = coordinates[1];
                int[] rowOffsets = {-1,0,1,0};
                int[] colOffsets = {0,-1,0,1};

                if (grid[row][col] == '#') return res;

                for (int d=0;d<4;d++) {
                    int newRow = row + rowOffsets[d];
                    int newCol = col + colOffsets[d];


                    if (newRow >= ROWS ||
                            newRow < 0 ||
                            newCol >= COLS ||
                            newCol < 0 ||
                            grid[newRow][newCol] == 'X' ||
                            visited[newRow][newCol] == 1
                    ) {
                        continue;
                    }


                    visited[newRow][newCol] = 1;
                    queue.add(new int[]{newRow, newCol});

                }
                size--;
            }
            res++;
        }

        return -1;
    }
}
