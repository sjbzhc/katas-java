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
    public void word_break_recur2() {
        WordBreak2 wb = new WordBreak2();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakRecur("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_memo() {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakMemo("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_memo2() {
        WordBreak2 wb = new WordBreak2();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakMemo("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_bfs() {
        WordBreak wb = new WordBreak();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakBfs("leetcode", dict)).isTrue();
    }

    @Test
    public void word_break_bfs2() {
        WordBreak2 wb = new WordBreak2();
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
    public void word_break_dp_2() {
        WordBreak2 wb = new WordBreak2();
        List<String> dict = List.of("leet","code");
        Assertions.assertThat(wb.wordBreakDp("leetcode", dict)).isTrue();
    }
}
