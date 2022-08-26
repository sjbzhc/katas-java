package leetcode;

import java.util.*;

/*
* Solved using A*
*
* Time: O(nk log nk) worst case: we visit all n cells, and each cell is visited k times for different elimination vals
* Space: O(nk)
* */

public class ShortestPathInGridWithObstacle {

    class State {
        public int estimation, steps, row, col, k;
        private int[] target;

        public State(int steps, int row, int col, int k, int[] target) {
            this.steps = steps;
            this.row = row;
            this.col = col;
            this.k = k;

            this.target = target;
            int manhattanDistance = target[0] - row + target[1] - col;
            this.estimation = manhattanDistance + steps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State stepState = (State) o;
            return estimation == stepState.estimation && steps == stepState.steps && row == stepState.row &&
                    col == stepState.col && k == stepState.k && Arrays.equals(target, stepState.target);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(estimation, steps, row, col, k);
            result = 31 * result + Arrays.hashCode(target);
            return result;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.estimation - b.estimation);
        HashSet<State> seen = new HashSet<>();

        State start = new State(0, 0, 0, k, target);
        queue.offer(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            int steps = curr.steps;
            int row = curr.row;
            int col = curr.col;
            int estimation = curr.estimation;
            int elimination = curr.k;

            // We have enough k to go through a path with obstacles only
            int remainMinDistance = estimation - steps;
            if (remainMinDistance <= elimination) return estimation;


            int[] rowOffsets = {-1, 0, 1, 0};
            int[] colOffsets = {0, -1, 0, 1};

            // explore the four directions in the next step
            for (int d=0; d<4; d++) {
                int newRow = row + rowOffsets[d];
                int newCol = col + colOffsets[d];

                if (0 > newRow || newRow >= rows || 0 > newCol || newCol >= cols) continue;

                int nextElimination = elimination - grid[newRow][newCol];
                State newState = new State(steps + 1, newRow, newCol, nextElimination, target);

                if (nextElimination >= 0 && !seen.contains(newState)) {
                    seen.add(newState);
                    queue.offer(newState);
                }
            }
        }

        return -1;
    }
}
