package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LettersThatOccurMostTests {
    @Test
    public void letters_that_occur() {
        LettersThatOccurMost lt = new LettersThatOccurMost();
        Map<Character, Set<Character>> expected = Map.of(
                'a', Set.of('f'),
                'b', Set.of('d', 'e'),
                'c', Set.of('d'),
                'd', Set.of('b', 'c'),
                'e', Set.of('b'),
                'f', Set.of('a')
                );

        Assertions.assertThat(lt.lettersThatOccurMost(List.of("abef", "bcd", "bde", "cadf"))).isEqualTo(expected);
    }
}
