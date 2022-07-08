package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    /*
    * Time: O(mn)
    * Space: O(1)
    * */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;

        while (l <= r && t <= b) {
            for (int j = l; j <= r; j++) {
                list.add(matrix[t][j]);
            }
            t++;

            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;

            if (!(l < r && t < b)) break;

            for (int j = r; j >= l; j--) {
                list.add(matrix[b][j]);
            }
            b--;

            for (int i = b; i >= t; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }

        return list;
    }
}
