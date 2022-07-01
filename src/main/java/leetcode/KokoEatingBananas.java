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
            int currentSpeed = (l + r) / 2;

            int time = 0;
            for (int p : piles) {
                time += Math.ceil((double) p / currentSpeed);
            }

            if (time <= h) {
                r = currentSpeed;
            } else l = currentSpeed + 1;
        }
        return r;
    }
}
