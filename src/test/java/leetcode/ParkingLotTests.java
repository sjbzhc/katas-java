package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class ParkingLotTests {
    @Test
    public void test() {

        ParkingLot.ParkingSpot ps1 = new ParkingLot.ParkingSpot(ParkingLot.ParkingSpotSize.SMALL, ParkingLot.ParkingSpotType.STANDARD);
        ParkingLot.ParkingSpot ps2 = new ParkingLot.ParkingSpot(ParkingLot.ParkingSpotSize.SMALL, ParkingLot.ParkingSpotType.DISABLED);

        List<ParkingLot.ParkingSpot> parkingLots = List.of(ps1, ps2);

        ParkingLot pl = new ParkingLot(parkingLots);

        Assertions.assertThat(pl.assignSpot(ParkingLot.CarSize.SMALL, ParkingLot.ParkingSpotType.DISABLED)).isEqualTo(ps2);
        Assertions.assertThat(pl.assignSpot(ParkingLot.CarSize.SMALL, ParkingLot.ParkingSpotType.STANDARD)).isEqualTo(ps1);
    }

    @Test
    public void too_many_assignments_with_valid_spots() {

        ParkingLot.ParkingSpot ps1 = new ParkingLot.ParkingSpot(ParkingLot.ParkingSpotSize.SMALL, ParkingLot.ParkingSpotType.STANDARD);
        ParkingLot.ParkingSpot ps2 = new ParkingLot.ParkingSpot(ParkingLot.ParkingSpotSize.SMALL, ParkingLot.ParkingSpotType.DISABLED);

        List<ParkingLot.ParkingSpot> parkingLots = List.of(ps1, ps2);

        ParkingLot pl = new ParkingLot(parkingLots);

        Assertions.assertThat(pl.assignSpot(ParkingLot.CarSize.SMALL, ParkingLot.ParkingSpotType.DISABLED)).isEqualTo(ps2);
        Assertions.assertThat(pl.assignSpot(ParkingLot.CarSize.SMALL, ParkingLot.ParkingSpotType.STANDARD)).isEqualTo(ps1);
    }
}
