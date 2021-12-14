package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ConnectCitiesMinimumCostTests {
    @Test
    public void connect_cities() {
        ConnectCitiesMinimumCost cc =  new ConnectCitiesMinimumCost();

        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};

        Assertions.assertThat(cc.minimumCost(3, connections)).isEqualTo(6);
    }

    @Test
    public void connect_cities_2() {
        ConnectCitiesMinimumCost cc =  new ConnectCitiesMinimumCost();

        int[][] connections = {{1, 2, 1}, {1, 3, 1}, {2, 4, 10}, {3,4,1}};

        Assertions.assertThat(cc.minimumCost(4, connections)).isEqualTo(3);
    }

    @Test
    public void connect_cities2() {
        ConnectCitiesMinimumCost2 cc =  new ConnectCitiesMinimumCost2();

        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};

        Assertions.assertThat(cc.minimumCost(3, connections)).isEqualTo(6);
    }

    @Test
    public void connect_cities3_2() {
        ConnectCitiesMinimumCost2 cc =  new ConnectCitiesMinimumCost2();

        int[][] connections = {{1, 2, 1}, {1, 3, 1}, {2, 4, 10}, {3,4,1}};

        Assertions.assertThat(cc.minimumCost(4, connections)).isEqualTo(3);
    }

    @Test
    public void connect_cities3_3() {
        ConnectCitiesMinimumCost2 cc =  new ConnectCitiesMinimumCost2();

        int[][] connections = {{1, 2, 3}, {3,4,4}};

        Assertions.assertThat(cc.minimumCost(4, connections)).isEqualTo(-1);
    }
}
