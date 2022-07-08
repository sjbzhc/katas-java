package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
* Time: O(n)
* Space: O(1)
* */

public class MergeTriplets {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;

            for (int i=0; i<triplet.length; i++) {
                if (triplet[i] == target[i]) set.add(i);
            }
        }
        return set.size() == 3;
    }
}
