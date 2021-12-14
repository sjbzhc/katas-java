package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class PairsOfSongsTests {
    @Test
    public void pairs_of_songs() {
        PairsOfSongs ps = new PairsOfSongs();
        int[] songs = {30,20,150,100,40};
        Assertions.assertThat(ps.numPairsDivisibleBy60(songs)).isEqualTo(3);
    }

    @Test
    public void pairs_of_songs_2() {
        PairsOfSongs2 ps = new PairsOfSongs2();
        int[] songs = {30,20,150,100,40};
        Assertions.assertThat(ps.numPairsDivisibleBy60(songs)).isEqualTo(3);
    }
}
