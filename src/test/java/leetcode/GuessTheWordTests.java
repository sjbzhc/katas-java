package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class GuessTheWordTests {
    @Test
    public void test() {
        GuessTheWord gw = new GuessTheWord();

        List<String> words = List.of("acckzz","ccbazz","eiowzz","abcczz");
        GuessTheWord.Master master = new GuessTheWord.Master(words, "acckzz", 5);
        String[] wds  = {"acckzz","ccbazz","eiowzz","abcczz"};

        gw.findSecretWord(wds, master);
    }
}
