package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
* Time: O(MxN)
* Space: O(MxN)
* */

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for (int i =0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
                dfs(grid, i, j);
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if (i < 0 || i >= ROWS || j < 0 || j >= COLS || grid[i][j] == '0') return;

        grid[i][j] = '0';

        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, -1, 0, 1};

        for (int d = 0; d < 4; d++) {
            dfs(grid, i + rows[d], j + cols[d]);
        }
    }

    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r =0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    grid[r][c] = '0';
                    Queue<Integer> neighbours = new LinkedList<>();
                    // We store the number of the cell, from 1 to n
                    neighbours.add(r * nc + c);
                    while (!neighbours.isEmpty()) {
                        int id = neighbours.remove();
                        int row = id / nc;
                        int col = id % nc;

                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbours.add((row-1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbours.add((row+1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbours.add(row * nc + (col-1));
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbours.add(row * nc + (col+1));
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return count;
    }
}
