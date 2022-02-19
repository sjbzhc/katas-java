package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class FirstUniqueCharacterInAStringTests {
    @Test
    public void first_unique_character() {
        FirstUniqueCharacterInAString fu = new FirstUniqueCharacterInAString();
        Assertions.assertThat(fu.firstUniqChar("leetcode")).isEqualTo(0);
    }

    @Test
    public void first_unique_character_2() {
        FirstUniqueCharacterInAString fu = new FirstUniqueCharacterInAString();
        Assertions.assertThat(fu.firstUniqChar("loveleetcode")).isEqualTo(2);
    }

    @Test
    public void first_unique_character_3() {
        FirstUniqueCharacterInAString fu = new FirstUniqueCharacterInAString();
        Assertions.assertThat(fu.firstUniqChar("aabb")).isEqualTo(-1);
    }
}
