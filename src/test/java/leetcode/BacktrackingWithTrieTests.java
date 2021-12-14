package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BacktrackingWithTrieTests {
    @Test
    public void backtracking_with_tries() {
        BacktrackingWithTrie bw = new BacktrackingWithTrie();

        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };

        String[] words = {"oath","pea","eat","rain"};

        String[] expected = {"eat","oath"};

        Assertions.assertThat(bw.findWords(board, words)).isEqualTo(expected);
    }
}
