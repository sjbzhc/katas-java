package leetcode;

/*
* Start with square's angles
*
* start with tl
* tl moves one spot to the right
* bl moves one spot up
* br moves one spot left
*
* We do the order counter clockwise to save tmp vars.
* We start with tl
* Then put bl in tl
* Then put br in bl
* Then put tr in br
* Then put tl in tr
*
* We add the i accordingly:
* tl right: + i to col index
* bl up: - i to row index
* br left: - i in col index
* tr down: + i in row
*
* */

/*
* l   r
* 1 2 3 t
* 4 5 6
* 7 8 9 b
* */

/*
* Time: O(n2)
* Space: O(1)
* */

public class RotateImage {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while (l < r) {
            // we want to do n-1 iterations.
            for (int i=0; i < r - l; i++) {
                // top = r and bottom = r since we have a square matrix
                int t = l;
                int b = r;

                // Save tl in tmp
                // tl moves to the left
                int tmp = matrix[t][l + i];

                // Move bl into tl
                // bl moves up
                matrix[t][l + i] = matrix[b - i][l];

                // Move br into bl
                // br moves to the left
                matrix[b - i][l] = matrix[b][r - i];

                // Move tr into br
                // tr moves down
                matrix[b][r - i] = matrix[t + i][r];

                // Move tl into tr
                matrix[t + i][r] = tmp;
            }
            l++;
            r--;
        }
    }

    /*
    * Time: O(n*m)
    * Space: O(1)
    * */

    public void rotate2(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

}
