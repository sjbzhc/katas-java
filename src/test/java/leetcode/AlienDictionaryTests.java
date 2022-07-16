package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class AlienDictionaryTests {
    @Test
    public void test() {
        AlienDictionary ad = new AlienDictionary();
        String[] words = {"wrt","wrf","er","ett","rftt"};

        Assertions.assertThat(ad.alienOrder(words)).isEqualTo("wertf");
    }
}
