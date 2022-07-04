package leetcode;

/*
* Time: O(nlog m)
* Space: O(1)
* */

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int p : piles) r = Math.max(r, p);

        while (l < r) {
            int m = (l + r) / 2;

            int time = 0;
            for (int p : piles) {
                time += Math.ceil((double) p / m);
            }

            if (time > h) {
                l = m + 1;

            } else r = m;
        }
        return r;
    }
}
