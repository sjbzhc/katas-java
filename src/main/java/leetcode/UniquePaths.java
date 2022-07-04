package leetcode;

import java.util.Arrays;

/*
* dp cells stand for number of paths from that cell. We calculate from bottom right, adding what's right and below
* we initialize bottom right to 1
*
* 0 0 0 0 0
* 0 0 0 0 0
* 0 0 0 1 0
* 0 0 0 0
*
* first iteration, first
* Time: O(mn)
* Space: O(mn)
* */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int i=0; i<m-1;i++) {
            int[] newRow = new int[n];
            newRow[newRow.length - 1] = 1;
            for (int j = n-2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        return row[0];
    }
}
