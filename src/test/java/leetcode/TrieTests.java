package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import leetcode.trie.Trie;
import leetcode.trie.TrieHash;
import org.junit.jupiter.api.Test;

public class TrieTests {
    @Test
    public void trie_tests() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True
        trie.insert("application");
        trie.search("app");     // return True
    }

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
