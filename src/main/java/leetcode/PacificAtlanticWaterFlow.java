package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(m * n)
* Space: O(m * n)
* */
public class PacificAtlanticWaterFlow {
    int R;
    int C;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        this.heights = heights;
        R = heights.length;
        C = heights[0].length;

        boolean[][] pacificReachable = new boolean[R][C];
        boolean[][] atlanticReachable = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, C - 1, atlanticReachable);
        }
        for (int i = 0; i < C; i++) {
            dfs(0, i, pacificReachable);
            dfs(R - 1, i, atlanticReachable);
        }

        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }


    private void dfs(int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;
        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, -1, 0, 1};
        for (int d=0;d<4;d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];

            if (newRow < 0 || newRow >= R || newCol < 0 || newCol >= C) {
                continue;
            }

            if (reachable[newRow][newCol]) {
                continue;
            }

            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, reachable);
        }
    }
}
