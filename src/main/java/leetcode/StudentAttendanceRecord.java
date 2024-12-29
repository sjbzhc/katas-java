package leetcode;

import java.util.Arrays;

public class StudentAttendanceRecord {
    private final int MOD = 1000000007;
    private int[][][] memo;

    /*
     * Time: O(n) will evaluate matrix of size nx2x3
     * Space: O(n) will store nx2x3
     *
     * Each call to eligibleCombinations calculates the 3 subproblems
     * */
    public int checkRecord(int n) {
        // Initialize the cache.
        memo = new int[n + 1][2][3];
        for (int[][] array2D : memo) {
            for (int[] array1D : array2D) {
                Arrays.fill(array1D, -1);
            }
        }
        return eligibleCombinations(n, 0, 0);
    }

    private int eligibleCombinations(int n, int totalAbsences, int consecutiveLates) {

        if (totalAbsences >= 2 || consecutiveLates >= 3) return 0;
        if (n == 0) return 1;

        if (memo[n][totalAbsences][consecutiveLates] != -1) return memo[n][totalAbsences][consecutiveLates];

        int count = 0;
        // P: no effect on totalAbsences or consecutiveLates
        count = eligibleCombinations(n - 1, totalAbsences, 0) % MOD;
        // A: effect on totalAbsences
        count = (count + eligibleCombinations(n - 1, totalAbsences + 1, 0)) % MOD;
        // L: effect on consecutiveLates
        count = (count + eligibleCombinations(n - 1, totalAbsences, consecutiveLates + 1)) %MOD;

        return memo[n][totalAbsences][consecutiveLates] = count;
    }


    int count;
    public int checkRecordRecurvise(int n) {
        count = 0;
        gen("", n);
        return count;
    }

    public void gen(String s, int n) {
        if (n == 0 && checkRecord(s)) count = (count + 1) % MOD;
        else if (n > 0) {
            gen(s + "A", n - 1);
            gen(s + "P", n - 1);
            gen(s + "L", n - 1);
        }
    }

    public boolean checkRecord(String s) {
        int count = 0;

        for (int i = 0; i < s.length() && count < 2; i++) {
            if (s.charAt(i) == 'A') count++;
        }

        return s.length() > 0 && count < 2 && s.contains("LLL");
    }
}
