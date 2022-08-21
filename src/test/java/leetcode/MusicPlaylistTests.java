package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MusicPlaylistTests {
    @Test
    public void test() {
        MusicPlaylist mp = new MusicPlaylist(10);

        mp.add("Song 1");

        Assertions.assertThat(mp.getTopSongs()).isEqualTo("Song 1, ");

        mp.add("Song 2");

        Assertions.assertThat(mp.getTopSongs()).isEqualTo("Song 2, Song 1, ");

        mp.add("Song 1");

        Assertions.assertThat(mp.getTopSongs()).isEqualTo("Song 1, Song 2, ");
    }
}
