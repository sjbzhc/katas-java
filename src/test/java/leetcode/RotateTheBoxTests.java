package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RotateTheBoxTests {
    @Test
    public void test() {
        RotateTheBox rt = new RotateTheBox();
        char[][] box = {{'#','.','#'}};

        char[][] res = {{'.'}, {'#'}, {'#'}};

        Assertions.assertThat(rt.rotateTheBox(box)).isEqualTo(res);
    }
}
