package leetcode;

import java.util.*;

public class SnakesAndLadders2 {

    public int snakesAndLadders(int[][] board) {
        int count = 0;
        int n = board.length;
        Map<Integer, Integer> map = createBoardMap(board);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int current = queue.poll();
                if (current == n*n) return count;
                for (int j=1; j<=6;j++) {
                    int next = current + j;
                    if (next > n*n) continue;
                    if (map.get(next) != -1) next = map.get(next);
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    /*
    * Maps the position in the game map (not board) to the value it holds. For example the board:
    * {4, 3}
    * {1, 2}
    * is transformed to:
    * { 1: 1, 2: 2, 3: 3, 4: 4}
    *
    * */
    public Map<Integer, Integer> createBoardMap(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = board.length;

        int currentNumber = 1;
        for (int r = n - 1; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                if (r % 2 != 0) {
                    map.put(currentNumber, board[r][c]);
                } else {
                    map.put(currentNumber, board[r][n - 1 - c]);
                }
                currentNumber++;
            }
        }
        return map;
    }
}
