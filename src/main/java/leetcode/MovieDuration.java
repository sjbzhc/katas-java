package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieDuration {
    public int[] movieDuration(int[] movieDurations, int duration) {
        duration -= 30;
        int[] res = new int[]{-1, -1};

        Arrays.sort(movieDurations);

        int l = 0;
        int r =movieDurations.length - 1;

        int sum = movieDurations[r] + movieDurations[l];
        if (sum < duration) {
            res = new int[]{l, r};
        }

        while (l < r) {
            int currentSum = movieDurations[r] + movieDurations[l];
            if (currentSum > sum && currentSum < duration) {
                res = new int[]{l, r};
            }
            if (currentSum <= sum) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
