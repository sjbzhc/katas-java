package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Time: O(n2)
* Space: O(n2)
* */

public class GetBiggestThreeRombus {
    int[][] grid;
    public int[] getBiggestThree(int[][] grid) {
        this.grid = grid;

        int m = grid.length;
        int n = grid[0].length;
        List<Integer> res = new ArrayList<>();

        for (int t=0; t<m; t++) {
            for (int j=0; j<n;j++) {
                int l = j;
                int r = j;
                int b = t;

                // here we create all possible sub-squares to contains the rombuses
                while (l >= 0 && r <= n-1 && b <= m-1) {
                    int sum = calc(l, r, t, b);
                    l--;
                    r++;
                    b += 2;
                    if (!res.contains(sum)) res.add(sum);
                }
            }
        }

        Collections.sort(res);

        int[] ans = new int[3];
        int count = 3;
        int i =0;
        while (count > 0) {
            ans[i] = res.get(res.size() - 1);
            res.remove(res.size() - 1);
            count--;
            i++;
        }
        return ans;
    }

    public int calc(int l, int r, int t, int b) {
        int sum = 0;
        int colLeft = (l + r) / 2;
        int colRight = colLeft;
        boolean expand = true;
        for (int row = t; row <= b; row++) {
            if (colLeft == colRight) {
                sum += grid[row][colLeft];
            } else {
                sum += grid[row][colLeft] + grid[row][colRight];
            }

            if (colLeft == l) expand = false;

            if (expand) {
                colLeft--;
                colRight++;
            } else {
                colLeft++;
                colRight--;
            }
        }
        return sum;
    }
}
