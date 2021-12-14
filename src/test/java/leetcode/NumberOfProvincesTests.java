package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class NumberOfProvincesTests {
    @Test
    public void number_of_provinces() {
        NumberOfProvinces np = new NumberOfProvinces();

        int[] r1 = {1,1,0};
        int[] r2 = {1,1,0};
        int[] r3 = {0,0,1};

        int[][] isConnected = {r1,r2,r3};

        Assertions.assertThat(np.findCircleNum(isConnected)).isEqualTo(2);

    }

    @Test
    public void number_of_provinces_3() {
        NumberOfProvinces np = new NumberOfProvinces();

        int[] r1 = {1,0,0};
        int[] r2 = {0,1,0};
        int[] r3 = {0,0,1};

        int[][] isConnected = {r1,r2,r3};

        Assertions.assertThat(np.findCircleNum(isConnected)).isEqualTo(3);

    }

    @Test
    public void number_of_provinces_3_simple() {
        NumberOfProvinces np = new NumberOfProvinces();

        int[] r1 = {1,0,0};
        int[] r2 = {0,1,0};
        int[] r3 = {0,0,1};

        int[][] isConnected = {r1,r2,r3};

        Assertions.assertThat(np.findCircleNumSimple(isConnected)).isEqualTo(3);

    }
}
