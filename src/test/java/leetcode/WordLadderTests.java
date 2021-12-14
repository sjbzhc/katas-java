package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class WordLadderTests {
    @Test
    public void word_ladder() {
        WordLadder wl = new WordLadder();
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

        Assertions.assertThat(wl.ladderLength("hit", "cog", wordList)).isEqualTo(5);
    }

    @Test
    public void word_ladder_2() {
        WordLadder2 wl = new WordLadder2();
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

        Assertions.assertThat(wl.ladderLength("hit", "cog", wordList)).isEqualTo(5);
    }

}
