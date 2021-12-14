package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ShortestPathToGetFoodTests {
    @Test
    public void shortest_path() {
        ShortestPathToGetFood sp = new ShortestPathToGetFood();
        char[][] grid = {
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };

        Assertions.assertThat(sp.getFood(grid)).isEqualTo(3);

    }

    @Test
    public void shortest_path_2() {
        ShortestPathToGetFood2 sp = new ShortestPathToGetFood2();
        char[][] grid = {
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };

        Assertions.assertThat(sp.getFood(grid)).isEqualTo(3);

    }
}
