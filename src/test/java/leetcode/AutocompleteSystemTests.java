package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteSystemTests {
    @Test
    public void autocomplete_system() {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem ac = new AutocompleteSystem(sentences, times);
        List<String> expected = new ArrayList<>();
        expected.add("i love you");
        expected.add("island");
        expected.add("i love leetcode");

        Assertions.assertThat(ac.input('i')).isEqualTo(expected);
    }
}
