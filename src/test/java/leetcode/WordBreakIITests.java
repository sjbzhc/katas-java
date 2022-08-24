package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class WordBreakIITests {
    @Test
    public void test() {
        WordBreakII wb = new WordBreakII();
        List<String> words = List.of("cat","cats","and","sand","dog");

        Assertions.assertThat(wb.wordBreak("catsanddog", words)).isEqualTo(List.of("cat sand dog","cats and dog"));
    }
}
