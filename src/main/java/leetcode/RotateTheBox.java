package leetcode;

/*
* Time: O(mn)
* Space: O(1)
* */
public class RotateTheBox {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // check each row
        for (int r = 0; r < m; r++) {
            int e = 0; // count empty cells from right
            for (int j = n - 1; j >= 0; j--) {
                if (box[r][j] == '.') e++;
                if (box[r][j] == '*') e = 0;

                // move stone to right if there is empty space on the right
                if (box[r][j] == '#' && e > 0) {
                    box[r][j+e] = '#';
                    box[r][j] = '.';
                }
            }
        }

        // 90 degree clockwise
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m-1-i] = box[i][j];
            }
        }

        return res;
    }
}
