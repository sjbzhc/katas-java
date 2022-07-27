package leetcode;

import java.util.HashSet;
import java.util.Set;

public class BagsOfRice {
    public int bagsOfRice(int[] bags) {
        Set<Integer> set = new HashSet<>();
        for (int b : bags) set.add(b);

        int ans = -1;
        for (int bag : set) {
            int current = bag;
            int count = 0;
            while (set.contains(current)) {
                count++;
                current *= current;
            }
            if (count >=2) ans = Math.max(ans, count);
        }

        return ans;
    }
}
