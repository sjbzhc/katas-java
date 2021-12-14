package leetcode;

import java.util.HashMap;
import java.util.Map;

//    int[] count;
//    public ParkingSystem(int big, int medium, int small) {
//        count = new int[]{big, medium, small};
//        }
//
//public boolean addCar(int carType) {
//        return count[carType - 1]-- > 0;
//        }

public class ParkingSystem {

    Map<Integer, Integer> usageMap = new HashMap<>();

    int[] usage = {0,0,0};
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        usageMap.put(1, 0);
        usageMap.put(2, 0);
        usageMap.put(3, 0);
    }

    /*
    * 1: big
    * 2: medium
    * 3: small
    * */
    public boolean addCar(int carType) {

        if (carType == 1 && usage[carType - 1] < big) {
            usage[carType - 1]++;
            return true;
        }

        if (carType == 2 && usage[carType -1] < medium) {
            usage[carType - 1]++;
            return true;
        }

        if (carType == 3 && usage[carType -1] < small) {
            usage[carType - 1]++;
            return true;
        }
        return false;
    }
}
