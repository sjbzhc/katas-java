package leetcode;

/*
* Different sizes of parking lots
* Can cars choose the parking spot freely? yes
* Can smaller cars take a bigger spot? no
* Can bigger cars take several spots? no
* Special spots: disabled? yes
*
*
* assignSpot(carSize, carType)
* freeSpot(parkingSpot)
*
* CarSizes: small, large
* ParkingSpotSizes: small, large
*
* ParkingSpotTypes: disabled, standard
*
* */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    enum CarSize {
        SMALL,
        LARGE
    }

    enum ParkingSpotSize {
        SMALL,
        LARGE
    }

    enum ParkingSpotType {
        DISABLED,
        STANDARD
    }

    public static class ParkingSpot {
        String id;
        ParkingSpotSize size;
        ParkingSpotType type;
        boolean occupied = false;

        public ParkingSpot(ParkingSpotSize size, ParkingSpotType type) {
            this.size = size;
            this.type = type;
        }
    }

    public interface IFilter {
        boolean isValid(ParkingSpot parkingSpot, Params params);
    }

    public class Params {
        ParkingSpotType type;
        CarSize size;
    }

    public class ParkingTypeFilter implements IFilter {
        @Override
        public boolean isValid(ParkingSpot parkingSpot, Params params) {
            if (params.type == null) return true;
            return params.type == parkingSpot.type;
        }
    }

    public class ParkingSizeFilter implements IFilter {
        @Override
        public boolean isValid(ParkingSpot parkingSpot, Params params) {
            if (params.size == null) return true;
            return carSizeToParkingSpotSize.get(params.size).contains(parkingSpot.size);
        }
    }

    public class ParkingOccupiedFilter implements IFilter {
        @Override
        public boolean isValid(ParkingSpot parkingSpot, Params params) {
            return !parkingSpot.occupied;
        }
    }

    public class Filter {
        List<IFilter> filters = new ArrayList<>();

        public Filter() {
            filters.add(new ParkingTypeFilter());
            filters.add(new ParkingSizeFilter());
            filters.add(new ParkingOccupiedFilter());
        }

        public boolean isValid(ParkingSpot parkingSpot, Params params) {
            for (IFilter filter: filters) {
                if (!filter.isValid(parkingSpot, params)) return false;
            }
            return true;
        }
    }

    List<ParkingSpot> parkingSpots;
    Filter filter = new Filter();

    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    Map<CarSize, List<ParkingSpotSize>> carSizeToParkingSpotSize = Map.of(
            CarSize.SMALL, List.of(ParkingSpotSize.SMALL, ParkingSpotSize.LARGE),
            CarSize.LARGE, List.of(ParkingSpotSize.LARGE)
    );

    public ParkingSpot assignSpot(CarSize carSize, ParkingSpotType parkingSpotType) {
            Params params = new Params();
            params.size = carSize;
            params.type = parkingSpotType;

            for (ParkingSpot ps : parkingSpots) {
                if (filter.isValid(ps, params)) {
                    ps.occupied = true;
                    return ps;
                }
            }
        throw new Error("No spots free for this type of vehicle");
    }

    public void freeSpot(ParkingSpot parkingSpot) {
        parkingSpot.occupied = false;
    }
}
