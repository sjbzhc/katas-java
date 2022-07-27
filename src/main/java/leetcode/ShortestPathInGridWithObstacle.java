package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestPathInGridWithObstacle {

    class StepState {
        public int steps, row, col, k;

        public StepState(int steps, int row, int col, int k) {
            this.steps = steps;
            this.row = row;
            this.col = col;
            this.k = k;
        }

        @Override
        public int hashCode() {
            return (row + 1) * (col + 1) * k;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof StepState)) {
                return false;
            }
            StepState newState = (StepState) other;
            return (row == newState.row) && (col == newState.col) && (k == newState.k);
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // if we have sufficient quotas to eliminate the obstacles in the worst case,
        // then the shortest distance is the Manhattan distance.
        if (k >= ROWS + COLS - 2) return ROWS + COLS - 2;

        LinkedList<StepState> queue = new LinkedList<>();
        Set<StepState> seen = new HashSet<>();

        // (steps, row, col, remaining quota to eliminate obstacles)
        StepState start = new StepState(0, 0, 0, k);
        queue.addLast(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            StepState curr = queue.pollFirst();
            int row = curr.row;
            int col = curr.col;
            int steps = curr.steps;

            // we reach the target here
            if (row == ROWS - 1 && col == COLS - 1) return curr.steps;

            int[] rowOffsets = {-1, 0, 1, 0};
            int[] colOffsets = {0, -1, 0 ,1};

            // explore the four directions in the next step
            for (int i = 0; i < 4; i++) {
                int nextRow = row + rowOffsets[i];
                int nextCol = col + colOffsets[i];

                if (nextRow < 0 || nextRow >= ROWS || nextCol < 0 || nextCol >= COLS) continue;

                int eliminationsLeft = curr.k - grid[nextRow][nextCol];
                StepState newState = new StepState(steps + 1, nextRow, nextCol, eliminationsLeft);

                // add the next move in the queue if it qualifies.
                if (eliminationsLeft >= 0 && !seen.contains(newState)) {
                    seen.add(newState);
                    queue.addLast(newState);
                }
            }
        }

        return -1;
    }
}
