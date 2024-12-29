package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class WordBreakTests {
    @Test
    public void word_break_recur() {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakRecur("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_memo() {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreak("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_bfs() {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakBfs("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_dp() {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakDp("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_dp_bottoms_up() {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakBottomsUp("leetcode", dict)).isTrue();
    }

}
