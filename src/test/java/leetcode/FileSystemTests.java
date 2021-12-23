package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class FileSystemTests {
    @Test
    public void file_system() {
        FileSystem fs = new FileSystem();
        Assertions.assertThat(fs.ls("/")).isEqualTo(List.of());

        fs.mkdir("/a/b/c");

        Assertions.assertThat(fs.ls("/")).isEqualTo(List.of("a"));

        fs.addContentToFile("/a/b/c/d", "hello");

        Assertions.assertThat(fs.readContentFromFile("/a/b/c/d")).isEqualTo("hello");

    }
}
