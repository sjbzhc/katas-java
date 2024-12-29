package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
* Time: O(n2)
* Space: O(n2)
*
* Works a bit like a printer. On the first step, we start in the middle of l and r and we add that value to res.
* On the next row, if we did not overflow on the left and right col positions, we add the values at (top, left) and (top, right)
* This keeps expanding until we overflow. At that point, we start to contract, until l and r we reach the current bottom.
* */

public class GetBiggestThreeRombus {
    int[][] grid;
    public int[] getBiggestThree(int[][] grid) {
        this.grid = grid;

        int m = grid.length;
        int n = grid[0].length;
        List<Integer> res = new ArrayList<>();

        for (int row=0; row<m; row++) {
            for (int column=0; column<n;column++) {
                int left = column;
                int right = column;
                int bottom = row;
                int top = row;

                // here we create all possible sub-squares to contains the rombuses
                while (left >= 0 && right <= n-1 && bottom <= m-1) {
                    int sum = calc(left, right, top, bottom);
                    left--;
                    right++;
                    bottom += 2;
                    if (!res.contains(sum)) res.add(sum);
                }
            }
        }

        Collections.sort(res);

        res = res.stream().filter(r -> r != 0).collect(Collectors.toList());

        int size = Math.min(3, res.size());
        int[] ans = new int[size];
        int count = size;
        int i=0;
        while (count > 0) {
            ans[i] = res.get(res.size() - 1);
            res.remove(res.size() - 1);
            count--;
            i++;
        }
        return ans;
    }

    public int calc(int left, int right, int top, int bottom) {
        int sum = 0;
        int m = (left + right) / 2;
        int colLeft = m;
        int colRight = m;
        boolean expand = true;
        for (int row = top; row <= bottom; row++) {
            if (colLeft == colRight) {
                sum += grid[row][colLeft];
            } else {
                sum += grid[row][colLeft] + grid[row][colRight];
            }

            if (colLeft == left) expand = false;

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
