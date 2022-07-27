package leetcode;

public class MinimumHealth {
    public long minimumHealth(int[] damage, int armor) {
        int max = 0;
        int len = damage.length;
        long sum = 0;

        for(int i = 0; i < len; i++){
            max = Math.max(damage[i], max);
            sum += damage[i];
        }
        sum -= Math.min(armor, max);
        return sum + 1;
    }
}
