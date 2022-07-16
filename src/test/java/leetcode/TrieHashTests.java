package leetcode;

import leetcode.trie.TrieHash;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
public class TrieHashTests {
    @Test
    public void trie_tests_hashmap() {
        TrieHash trie = new TrieHash();
        trie.insert("apple");

        Assertions.assertThat(trie.search("apple")).isTrue();
        Assertions.assertThat(trie.search("app")).isFalse();
        Assertions.assertThat(trie.startsWith("app")).isTrue();
        Assertions.assertThat(trie.startsWith("apps")).isFalse();

        trie.insert("app");

        Assertions.assertThat(trie.search("app")).isTrue();
        Assertions.assertThat(trie.search("app")).isTrue();

        trie.insert("application");

        Assertions.assertThat(trie.search("application")).isTrue();
    }
}
