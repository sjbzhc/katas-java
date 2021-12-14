package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongs2 {
    public int numPairsDivisibleBy60(int[] songs) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int song : songs) {
            int currentCount = map.getOrDefault(0, 0);
            int mod = song % 60;
            if (mod == 0) {
               result += map.get(0);
            } else {
                result += map.getOrDefault(60 - mod, 0);
            }
            map.put(mod, currentCount + 1);
        }
        return result;
    }
}
