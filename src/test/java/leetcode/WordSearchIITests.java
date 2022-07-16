package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class WordSearchIITests {
    @Test
    public void words_search() {
        WordSearchII ws = new WordSearchII();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> result = List.of("oath", "eat");
        Assertions.assertThat(ws.findWords(board, words)).isEqualTo(result);
    }

    @Test
    public void words_search_2() {
        WordSearchII ws = new WordSearchII();
        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = {"oa","oaa"};
        List<String> result = List.of("oa","oaa");
        Assertions.assertThat(ws.findWords(board, words)).isEqualTo(result);
    }
}
