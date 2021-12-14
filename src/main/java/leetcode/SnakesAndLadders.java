package leetcode;

import java.util.*;

/*
* First convert the board to a map, linking the number in the board game (e.g. 31 instead of (0,5)) with the value of
* the cell (-1 if empty, next cell's number if ladder or snake).
*
* We use bfs so that we can guarantee that the first solution we find has the shortest amount of moves, as it will be
* the first time the goal has been encountered.
*
* We first add 1. The from 1 we will generate all possible steps (2-7), taking into consideration the snakes and ladders.
* So the queue might have something like (2,3,17,4,1,7) after the first round.
*
* We increase the count after we have inspected all of current level nodes and their children. These are all the nodes
* at the same level in the tree. We know that we finished a level since we are only polling as many elements as we had
* in the queue before we started adding them (first for loop).
*
* */

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {

        Map<Integer, Integer> boardMap = createBoard(board);

        int count = 0;
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(1);
        visited.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int current = queue.poll();
                if (current == n * n) {
                    return count;
                }
                for (int j=1; j<=6; j++) {
                    int next = current + j;
                    if (next > n * n) {
                        continue;
                    }
                    if (boardMap.get(next) != -1) {
                        next = boardMap.get(next);
                    }
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private Map<Integer, Integer> createBoard(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = board.length;
        int start = n * n;

        for (int i=0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                if ((n-i) % 2 == 0) {
                    map.put(start, board[i][j]);
                } else {
                    map.put(start, board[i][n -j -1]);
                }
                start--;
            }
        }
        return map;
    }
}
