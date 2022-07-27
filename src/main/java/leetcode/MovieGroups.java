package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieGroups {
    public int movieGroups(int[] movies, int k) {
        Arrays.sort(movies);

        List<Integer> current = new ArrayList<>();
        int res = 0;

        for (int i=0; i<movies.length; i++) {
            if (current.isEmpty() || movies[i] - current.get(0) < k) {
                current.add(movies[i]);
            } else {
                res++;
                current = new ArrayList<>();
            }
        }

        if (!current.isEmpty()) res++;
        return res;
    }
}
