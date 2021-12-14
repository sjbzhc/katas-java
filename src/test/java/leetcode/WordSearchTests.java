package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.PriorityQueue;

public class WordSearchTests {
    @Test
    public void word_search() {
        char[] b1 = {'A','B','C','E'};
        char[] b2 = {'S','F','C','S'};
        char[] b3 = {'A','D','E','E'};
        char[][] board = {b1, b2, b3};
        WordSearch wordSearch = new WordSearch();
        Assertions.assertThat(wordSearch.exist(board, "ABCCED")).isTrue();
    }

    @Test
    public void word_search_2() {
        char[] b1 = {'A','B','C','E'};
        char[] b2 = {'S','F','C','S'};
        char[] b3 = {'A','D','E','E'};
        char[][] board = {b1, b2, b3};
        WordSearch2 wordSearch = new WordSearch2();
        Assertions.assertThat(wordSearch.exist(board, "ABCCED")).isTrue();
    }
}
