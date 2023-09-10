package leetcode;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
* https://leetcode.com/problems/design-snake-game/editorial/
* Time: O(1)
* Space: O(wh + n), with n the number of food items
* */

public class SnakeGame {
    int width;
    int height;
    Set<Pair<Integer, Integer>> snakeInBoard;
    LinkedList<Pair<Integer, Integer>> snake;
    int[][] food;
    int foodIndex = 0;


    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        snakeInBoard = new HashSet<>();
        snake = new LinkedList<>();
        snakeInBoard.add(new Pair<>(0,0));
        snake.add(new Pair<>(0, 0));
        this.food = food;
    }

    public int move(String direction) {
        Pair<Integer, Integer> currentHead = snake.peekFirst();
        Pair<Integer, Integer> currentTail = snake.peekLast();
        int currentRow = currentHead.getKey();
        int currentCol = currentHead.getValue();

        if (direction.equals("U")) currentRow--;
        if (direction.equals("D")) currentRow++;
        if (direction.equals("L")) currentCol--;
        if (direction.equals("R")) currentCol++;

        Pair<Integer, Integer> newPosition = new Pair<>(currentRow, currentCol);

        if (currentRow >= height || currentRow < 0 || currentCol >= width || currentCol < 0) return -1;

        if (snakeInBoard.contains(newPosition) && !newPosition.equals(currentTail)) return -1;

        if (foodIndex < food.length && currentRow == food[foodIndex][0] && currentCol == food[foodIndex][1]) {
            foodIndex++;
        } else {
            snake.pollLast();
            snakeInBoard.remove(currentTail);
        }

        snake.addFirst(newPosition);
        snakeInBoard.add(newPosition);

        return snake.size() -1;
    }
}
