package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
* Time: O(m*n)
* Space: O(n)
* */

public class ShortestPathToGetFood {

    public int getFood(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count = 0;
        int[][] visited = new int[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();

        for (int r=0;r<ROWS;r++) {
            for (int c=0; c<COLS;c++) {
                if (grid[r][c] == '*') {
                    q.add(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] coordinates = q.poll();
                int row = coordinates[0];
                int col = coordinates[1];
                int[] rowOffset = {-1,0,1,0};
                int[] colOffset = {0,-1,0,1};

                if (grid[row][col] == '#') return count;

                for (int d=0;d<4;d++) {
                    int newRow = row + rowOffset[d];
                    int newCol = col + colOffset[d];

                    if (newRow < 0 ||
                            newRow >= ROWS ||
                            newCol < 0 ||
                            newCol >= COLS ||
                            grid[newRow][newCol] == 'X' ||
                            visited[newRow][newCol] == 1
                    ) {
                        continue;
                    }
                    visited[newRow][newCol] = 1;
                    q.add(new int[]{newRow, newCol});
                }
                size--;
            }
            count++;
        }
        return -1;
    }
}
