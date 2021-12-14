package leetcode;

public class RangeAddition2 {
    public int[] getModifiedArrayWithCaching(int length, int[][] updates) {
        int[] result = new int[length];

        for (int[] update : updates) {
            int lower = update[0];
            int upper = update[1] + 1;
            int increment = update[2];
            result[lower] += increment;
            if (upper < length - 1) {
                result[upper] -= increment;
            }
        }

        for (int i=1; i< length;i++) {
            result[i] = result[i] + result[i-1];
        }
        return result;
    }
}
