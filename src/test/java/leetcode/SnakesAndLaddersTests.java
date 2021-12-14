package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class SnakesAndLaddersTests {
    @Test
    public void snakes_and_ladders() {
        SnakesAndLadders sal = new SnakesAndLadders();
        int[] r1 = {-1,-1};
        int[] r2 = {-1, 3};
        int[][] board = {r1, r2};

        Assertions.assertThat(sal.snakesAndLadders(board)).isEqualTo(1);
    }

    @Test
    public void snakes_and_ladders_2_create_board() {
        SnakesAndLadders2 sal = new SnakesAndLadders2();
        int[] r1 = {4, 3};
        int[] r2 = {1, 2};
        int[][] board = {r1, r2};

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1,1);
        expected.put(2,2);
        expected.put(3,3);
        expected.put(4,4);

        Assertions.assertThat(sal.createBoardMap(board)).isEqualTo(expected);
    }

    @Test
    public void snakes_and_ladders_2() {
        SnakesAndLadders2 sal = new SnakesAndLadders2();
        int[] r1 = {-1,-1};
        int[] r2 = {-1, 3};
        int[][] board = {r1, r2};

        Assertions.assertThat(sal.snakesAndLadders(board)).isEqualTo(1);
    }

    @Test
    public void snakes_and_ladders_2_bigger_board() {
        SnakesAndLadders2 sal = new SnakesAndLadders2();
        int[] r1 = {-1,-1,-1,-1,-1,-1};
        int[] r2 = {-1,-1,-1,-1,-1,-1};
        int[] r3 = {-1,-1,-1,-1,-1,-1};
        int[] r4 = {-1,35,-1,-1,13,-1};
        int[] r5 = {-1,-1,-1,-1,-1,-1};
        int[] r6 = {-1,15,-1,-1,-1,-1};
        int[][] board = {r1, r2,r3,r4,r5,r6};

        Assertions.assertThat(sal.snakesAndLadders(board)).isEqualTo(4);
    }
}
