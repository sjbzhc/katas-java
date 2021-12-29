package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class ConcatenatedWordsTests {
    @Test
    public void concatenated_words() {
        ConcatenatedWords cw = new ConcatenatedWords();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> expected = List.of("dogcatsdog", "catsdogcats", "ratcatdogcat");
        Assertions.assertThat(cw.findAllConcatenatedWordsInADict(words)).isEqualTo(expected);
    }

    @Test
    public void concatenated_words_2_1() {
        ConcatenatedWords2 cw = new ConcatenatedWords2();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> expected = List.of("dogcatsdog", "catsdogcats", "ratcatdogcat");
        Assertions.assertThat(cw.findAllConcatenatedWordsInADict(words)).isEqualTo(expected);
    }

    @Test
    public void concatenated_words_2() {
        ConcatenatedWords cw = new ConcatenatedWords();
        String[] words = {"cat","dog", "catdog"};
        List<String> expected = List.of("catdog");
        Assertions.assertThat(cw.findAllConcatenatedWordsInADict(words)).isEqualTo(expected);
    }
}
