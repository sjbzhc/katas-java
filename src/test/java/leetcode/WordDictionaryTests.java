package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class WordDictionaryTests {
    @Test
    public void test() {
        WordDictionary wd = new WordDictionary();

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertThat(wordDictionary.search("pad")).isFalse();
        Assertions.assertThat(wordDictionary.search("bad")).isTrue();
        Assertions.assertThat(wordDictionary.search(".ad")).isTrue();
        Assertions.assertThat(wordDictionary.search("b..")).isTrue();
    }
}
