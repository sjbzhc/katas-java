package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class ParkingSystemTest {

    @Test
    public void parking_system_can_add_5_small_cars() {
        ParkingSystem ps = new ParkingSystem(0, 0, 5);
        ps.addCar(3);
        ps.addCar(3);
        ps.addCar(3);
        ps.addCar(3);
        boolean b = ps.addCar(3);

        Assertions.assertThat(b).isTrue();
    }

    @Test
    public void parking_system_cannot_add_6_small_cars() {
        ParkingSystem ps = new ParkingSystem(0, 0, 5);
        ps.addCar(3);
        ps.addCar(3);
        ps.addCar(3);
        ps.addCar(3);
        boolean b = ps.addCar(3);

        Assertions.assertThat(b).isTrue();

        b = ps.addCar(3);

        Assertions.assertThat(b).isFalse();


    }
}
