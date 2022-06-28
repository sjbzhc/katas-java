package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class GroupAnagramsTests {
    @Test
    public void group_anagrams() {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"));

        Assertions.assertThat(ga.groupAnagrams(strings).size()).isEqualTo(3);
    }
}
